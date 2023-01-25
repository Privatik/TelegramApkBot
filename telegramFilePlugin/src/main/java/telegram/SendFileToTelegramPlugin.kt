package telegram

import com.android.build.gradle.internal.crash.afterEvaluate
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Exec
import org.jetbrains.kotlin.gradle.plugin.*

class SendFileToTelegramPlugin: KotlinCompilerPluginSupportPlugin  {

    override fun apply(target: Project) {
        target.extensions.create("telegram", SendFileToTelegramExtension::class.java)

        target.tasks.register("sendToTelegram", Exec::class.java){ task ->
            val extension = target.extensions.getByName("telegram") as SendFileToTelegramExtension

            task.dependsOn(extension.runAfterTask.get())

            task.commandLine(
                "curl",
                "-F",
                "document=@${extension.pathToFile.asFile.get()}",
                "\"https://api.telegram.org/bot${extension.botToken.get()}/sendDocument?chat_id=${extension.chatId.get()}\""
            )
        }

    }

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project

        return project.provider {
            listOf(
                SubpluginOption(key = "isSend", value = "true")
            )
        }
    }

    override fun getCompilerPluginId(): String = "send.file.telegram.id"

    override fun getPluginArtifact(): SubpluginArtifact =
        SubpluginArtifact(
            groupId = "io.privatik",
            artifactId = "send-file-to-telegram-plugin-compile",
            version = "1.0.0-SNAPSHOT"
        )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean =
        kotlinCompilation.platformType == KotlinPlatformType.jvm
                || kotlinCompilation.platformType == KotlinPlatformType.androidJvm
}
package send_to_telegram

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Exec
import org.jetbrains.kotlin.gradle.plugin.*

class SendFileToTelegramPlugin: KotlinCompilerPluginSupportPlugin  {
    private val id = "send-file-to-telegram-plugin"

    override fun apply(target: Project) {
        val extension = target.extensions.create("telegram", SendFileToTelegramExtension::class.java)

        val pathToFile = extension.pathToFile
        val runAfterTask = extension.runAfterTask
        val botToken = extension.botToken
        val chatId = extension.chatId

        val sendTask = target.tasks.register("sendToTelegram", Exec::class.java){ task ->
            task.commandLine(
                "curl",
                "-F",
                "document=@${pathToFile.asFile.get()}",
                "\"https://api.telegram.org/bot${botToken.get()}/sendDocument?chat_id=${chatId.get()}\""
            )
        }

        target.tasks.getByName(runAfterTask.get()).finalizedBy(sendTask)

    }

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project

        return project.provider {
            listOf(
                SubpluginOption(key = "isSend", value = "true")
            )
        }
    }

    override fun getCompilerPluginId(): String = id

    override fun getPluginArtifact(): SubpluginArtifact =
        SubpluginArtifact(
            groupId = "io.privatik",
            artifactId = id,
            version = "1.0.0-SNAPSHOT"
        )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean =
        kotlinCompilation.platformType == KotlinPlatformType.jvm
                || kotlinCompilation.platformType == KotlinPlatformType.androidJvm
}
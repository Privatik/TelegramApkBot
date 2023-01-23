package send_to_telegram

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import java.io.File

abstract class SendFileToTelegramExtension {
    abstract val pathToFile: RegularFileProperty
    abstract val runAfterTask: Property<String>
    abstract val botToken: Property<String>
    abstract val chatId: Property<String>
}
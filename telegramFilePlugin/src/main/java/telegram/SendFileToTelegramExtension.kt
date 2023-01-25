package telegram

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.internal.file.ManagedFactories
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import java.io.File
import javax.inject.Inject

abstract class SendFileToTelegramExtension @Inject constructor(objects: ObjectFactory) {
    val pathToFile: RegularFileProperty =
        objects.fileProperty()
    val runAfterTask: Property<String> =
        objects.property(String::class.java).convention("build")
    val botToken: Property<String> =
        objects.property(String::class.java).convention("")
    val chatId: Property<String> =
        objects.property(String::class.java).convention("")
}
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TelegramApkBot"
include(":simple")
includeBuild("telegramFilePlugin"){
    dependencySubstitution {
        substitute(module("io.privatik:send-file-to-telegram-plugin-compile")).using(project(":"))
    }
}
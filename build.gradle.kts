
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("io.privatik:send-file-to-telegram-plugin-compile")
    }
}
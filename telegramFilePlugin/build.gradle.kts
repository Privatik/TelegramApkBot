plugins {
    kotlin("jvm") version "1.7.10"
    `java-gradle-plugin`
    kotlin("kapt") version "1.7.10"
    id("maven-publish")
}

group = "io.privatik"
version = "1.0.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("sendToTelegram-plugin"){
            id = "io.privatik.send-file-to-telegram-plugin"
            implementationClass = "telegram.SendFileToTelegramPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.7.10")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    compileOnly("com.android.tools.build:gradle:4.1.1")

    compileOnly("com.google.auto.service:auto-service-annotations:1.0")
    kapt("com.google.auto.service:auto-service:1.0")
}
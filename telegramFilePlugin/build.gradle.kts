plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    id("kotlin-kapt")
    id("maven-publish")
}

group = "io.privatik"
version = "1.0.0-SNAPSHOT"

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:4.1.1")
    }
}

gradlePlugin {
    plugins {
        create("sendToTelegram-plugin"){
            id = "io.privatik.send-file-to-telegram-plugin"
            implementationClass = "send_to_telegram.SendFileToTelegramPlugin"
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
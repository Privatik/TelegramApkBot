plugins {
    kotlin("jvm") version "1.7.10"
    java
    id("io.privatik.send-file-to-telegram-plugin") version "1.0.0-SNAPSHOT"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

//telegram {
//    runAfterTask.set("compileKotlin")
//    chatId.set("529988695")
//    botToken.set("5424229316:AAHL8zAM_GLa9hAbHQeWSI8N-fvjo1P3A78")
//    pathToFile.set(layout.projectDirectory.file("test.txt"))
//}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
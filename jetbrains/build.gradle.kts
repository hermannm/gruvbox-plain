plugins {
    id("org.jetbrains.intellij") version "1.12.0"
    kotlin("jvm") version "1.5.10"
}

group = "dev.hermannm"
version = "0.2.0"

repositories {
    mavenCentral()
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("223.8214.52")
    plugins.set(listOf("com.intellij.java"))
}

tasks {
    patchPluginXml {
        changeNotes.set("in development, unstable")
        sinceBuild.set("223.8214.52")
    }
}

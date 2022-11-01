plugins {
    id("org.jetbrains.intellij") version "1.10.0-SNAPSHOT"
    kotlin("jvm") version "1.5.10"
}

group = "dev.hermannm"
version = "0.2.0"

repositories {
    mavenCentral()
    maven("https://www.jetbrains.com/intellij-repository/snapshots")
}

dependencies {
    implementation(kotlin("stdlib"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("223-EAP-SNAPSHOT")
    plugins.set(listOf("com.intellij.java"))
}

tasks {
    patchPluginXml {
        changeNotes.set("in development, unstable")
    }
}

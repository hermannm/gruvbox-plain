plugins {
    kotlin("jvm") version "1.5.10"
    id("org.jetbrains.intellij") version "1.12.0"
    id("org.jmailen.kotlinter") version "3.15.0"
}

group = "dev.hermannm"
version = "0.2.0"

repositories {
    mavenCentral()
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2023.1")
    type.set("IC")
    plugins.set(listOf("com.intellij.java"))
    updateSinceUntilBuild.set(false)
}

tasks {
    patchPluginXml {
        changeNotes.set("in development, unstable")
        sinceBuild.set("231")
    }
}

sourceSets {
    main {
        kotlin.setSrcDirs(listOf("src"))
        java.setSrcDirs(listOf("src"))
        resources.setSrcDirs(listOf("resources"))
    }
    test {
        kotlin.setSrcDirs(listOf("test"))
        java.setSrcDirs(listOf("test"))
        resources.setSrcDirs(listOf("test-resources"))
    }
}

import org.jetbrains.intellij.platform.gradle.tasks.RunIdeTask

group = "dev.hermannm"
version = "0.3.1"

plugins {
    kotlin("jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.3")
        instrumentationTools()
        bundledPlugin("com.intellij.java")
    }
}

intellijPlatform {
    pluginConfiguration {
        name = "gruvbox-plain"
        ideaVersion {
            sinceBuild = "243"
        }
    }
}

tasks.named<RunIdeTask>("runIde") {
    jvmArgumentProviders += CommandLineArgumentProvider {
        listOf("-Didea.kotlin.plugin.use.k2=true")
    }
}

kotlin {
    jvmToolchain(21)
}

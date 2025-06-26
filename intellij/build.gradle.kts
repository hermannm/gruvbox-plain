import org.jetbrains.intellij.platform.gradle.tasks.RunIdeTask

group = "dev.hermannm"

version = "0.3.1"

plugins {
  kotlin("jvm") version "2.2.0"
  id("org.jetbrains.intellij.platform") version "2.6.0"
}

repositories {
  mavenCentral()

  intellijPlatform { defaultRepositories() }
}

dependencies {
  intellijPlatform {
    intellijIdeaCommunity("2025.1.1.1")
    bundledPlugin("com.intellij.java")
  }
}

intellijPlatform {
  pluginConfiguration {
    name = "gruvbox-plain"
    ideaVersion { sinceBuild = "251" }
  }
}

tasks.named<RunIdeTask>("runIde") {
  jvmArgumentProviders += CommandLineArgumentProvider { listOf("-Didea.kotlin.plugin.use.k2=true") }
}

kotlin {
  jvmToolchain(21)

  explicitApi()

  compilerOptions { freeCompilerArgs.set(listOf("-Xwhen-guards")) }
}

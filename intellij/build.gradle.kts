import org.jetbrains.changelog.Changelog
import org.jetbrains.intellij.platform.gradle.tasks.RunIdeTask

group = "dev.hermannm"

version = "0.4.0"

plugins {
  kotlin("jvm") version "2.2.0"
  id("org.jetbrains.intellij.platform") version "2.6.0"
  id("org.jetbrains.changelog") version "2.2.1"
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

tasks {
  patchPluginXml {
    changeNotes.set(
        provider {
          buildString {
            for ((version, changelogItem) in changelog.getAll()) {
              if (version != "Unreleased") {
                append("<h3>v${version}</h3>\n")
                append(
                    changelog.renderItem(
                        changelogItem.withHeader(false),
                        Changelog.OutputType.HTML,
                    ),
                )
              }
            }
          }
        },
    )
  }
}

// Generates IntelliJ plugin change notes from the root CHANGELOG.md
changelog {
  path.set(file("../CHANGELOG.md").canonicalPath)
  headerParserRegex.set(Regex("""v(\d+\.\d+\.\d+)"""))
}

tasks.named<RunIdeTask>("runIde") {
  jvmArgumentProviders += CommandLineArgumentProvider { listOf("-Didea.kotlin.plugin.use.k2=true") }
}

kotlin {
  jvmToolchain(21)

  explicitApi()

  compilerOptions { freeCompilerArgs.set(listOf("-Xwhen-guards")) }
}

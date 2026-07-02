import org.jetbrains.changelog.Changelog
import org.jetbrains.intellij.platform.gradle.tasks.RunIdeTask

group = "dev.hermannm"

version = "0.5.0"

// Updating Gradle: Run `./gradlew wrapper --gradle-version <version>`
// https://gradle.org/releases
plugins {
  // https://github.com/jetbrains/kotlin/releases
  kotlin("jvm") version "2.4.0"
  // https://plugins.gradle.org/plugin/org.jetbrains.intellij.platform
  id("org.jetbrains.intellij.platform") version "2.16.0"
  // https://plugins.gradle.org/plugin/org.jetbrains.changelog
  id("org.jetbrains.changelog") version "2.5.0"
}

dependencies {
  intellijPlatform {
    // https://www.jetbrains.com/idea/download/other/
    intellijIdea("2026.1.3")
    bundledPlugin("com.intellij.java")
  }
}

intellijPlatform {
  pluginConfiguration {
    name = "gruvbox-plain"
  }
}

kotlin {
  // https://www.jetbrains.com/help/idea/supported-java-versions.html
  jvmToolchain(25)

  explicitApi()
}

repositories {
  mavenCentral()

  intellijPlatform { defaultRepositories() }
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

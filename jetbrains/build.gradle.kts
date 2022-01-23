plugins {
    id("org.jetbrains.intellij") version "1.3.1"
    kotlin("jvm") version "1.5.10"
}

group = "com.hermannm"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.3.1")
}
tasks {
    patchPluginXml {
        changeNotes.set("in development, unstable")
    }
}
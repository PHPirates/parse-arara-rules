plugins {

    val kotlinVersion = "1.4.32"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.38.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.16"

    kotlin("plugin.serialization") version "1.4.32"

}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc-218")
    implementation("com.charleskorn.kaml:kaml:0.30.0")
    implementation("org.islandoftex.arara:arara-api:6.1.0")
    implementation("org.islandoftex.arara:arara-cli:6.1.0")
    implementation("org.islandoftex.arara:arara-mvel:6.1.0")
    implementation("org.islandoftex.arara:arara-core:6.1.0")
    implementation("org.slf4j:slf4j-api:1.7.30")
}

repositories {
    maven {
        url = uri("https://gitlab.com/api/v4/projects/14349047/packages/maven")
    }
    mavenCentral()
    mavenLocal()
    jcenter()
}

tasks.compileKotlin {
    kotlinOptions {
        languageVersion = "1.4"
        apiVersion = "1.4"
        jvmTarget = "11"
    }
}

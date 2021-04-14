plugins {

    val kotlinVersion = "1.5.0-M2"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.38.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.16"

    kotlin("plugin.serialization") version "1.5.0-M2"

}

dependencies {
    implementation(kotlin("stdlib"))
    // To "prevent strange errors".
    implementation(kotlin("reflect"))
    // Kotlin reflection.
    implementation(kotlin("test"))
    implementation(kotlin("test-junit"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc-218")
    implementation("com.charleskorn.kaml:kaml:0.30.0")

    implementation("org.islandoftex.arara:arara-api:6.1.0")
    implementation("org.islandoftex.arara:arara-cli:6.1.0")
    implementation("org.islandoftex.arara:arara-mvel:6.1.0")
    implementation("org.islandoftex.arara:arara-core:6.1.0")

    // Transitive dependencies
    implementation("com.soywiz.korlibs.korio:korio:2.0.9")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("io.github.microutils:kotlin-logging:2.0.6")
}

repositories {
    // Based on https://docs.gitlab.com/ee/user/packages/maven_repository/#authenticate-to-the-package-registry-with-maven
    maven {
        // As shown on GitLab
        url = uri("https://gitlab.com/api/v4/projects/14349047/packages/maven")
        // Also not working:
//        url = uri("https://gitlab.com/api/v4/projects/1512074/packages/maven")
//        url = uri("https://gitlab.com/api/v4/groups/org.islandoftex.arara/-/packages/maven")
        name = "GitLab"
        credentials(HttpHeaderCredentials::class) {
            name = "Private-Token"
            // From a gradle.properties file
            value = properties["gitLabPrivateToken"] as String
        }
        authentication {
            create<HttpHeaderAuthentication>("header")
        }
    }
    mavenCentral()
    mavenLocal()
    jcenter()
}

tasks.compileKotlin {
    kotlinOptions {
        languageVersion = "1.5"
        apiVersion = "1.5"
    }
}
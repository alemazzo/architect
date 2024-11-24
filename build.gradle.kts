import org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
    id("org.jetbrains.kotlin.kapt") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.4"
}

version = "0.1"
group = "io.github.alemazzo"

val kotlinVersion = project.properties["kotlinVersion"]
repositories {
    mavenCentral()
}

dependencies {
    kapt("info.picocli:picocli-codegen")
    kapt("io.micronaut.serde:micronaut-serde-processor")
    implementation("info.picocli:picocli")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
}


application {
    mainClass = "io.github.alemazzo.architect.ArchitectCommand"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}


micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("io.github.alemazzo.architect.*")
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


// Enforce Kotlin version coherence
configurations.matching { it.name != "detekt" }.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin" && requested.name.startsWith("kotlin")) {
            useVersion(VERSION)
            because("All Kotlin modules should use the same version, and compiler uses $VERSION")
        }
    }
}


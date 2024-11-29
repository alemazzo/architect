val kotlinVersion = project.properties["kotlinVersion"] as String? ?: "1.9.0"

version = "0.1"

group = "io.github.alemazzo"

plugins {
	id("org.jetbrains.kotlin.jvm") version "1.9.25"
	id("org.jetbrains.kotlin.kapt") version "1.9.25"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
	id("com.github.johnrengelman.shadow") version "8.1.1"
	id("io.micronaut.application") version "4.4.4"
}

repositories { mavenCentral() }

dependencies {
	kapt("info.picocli:picocli-codegen")
	kapt("io.micronaut.serde:micronaut-serde-processor")
	implementation("info.picocli:picocli")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
	implementation("io.micronaut.picocli:micronaut-picocli")
	implementation("io.micronaut.serde:micronaut-serde-jackson")
	implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.micronaut:micronaut-http-client")
	runtimeOnly("ch.qos.logback:logback-classic")
	runtimeOnly("org.yaml:snakeyaml")
}

application { mainClass = "io.github.alemazzo.architect.cli.ArchitectLauncher" }

micronaut {
	testRuntime("junit5")
	processing {
		incremental(true)
		annotations("io.github.alemazzo.architect.cli.*")
	}
}

// Architect

java { sourceCompatibility = JavaVersion.toVersion("21") }

kotlin { jvmToolchain { languageVersion.set(JavaLanguageVersion.of(21)) } }

tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
	jdkVersion = "21"
}

// Enforce Kotlin version coherence
configurations
	.matching { it.name != "detekt" }
	.all {
		resolutionStrategy.eachDependency {
			if (requested.group == "org.jetbrains.kotlin" && requested.name.startsWith("kotlin")) {
				useVersion(kotlinVersion)
				because(
					"All Kotlin modules should use the same version, and compiler uses $kotlinVersion"
				)
			}
		}
	}

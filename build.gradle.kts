val kotlinVersion = project.properties["kotlinVersion"] as String? ?: "1.9.24"

version = "4.23.6"

group = "io.github.alemazzo.architect"

plugins {
	id("org.jetbrains.kotlin.jvm") version "1.9.25"
	id("org.jetbrains.kotlin.kapt") version "1.9.25"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
	id("com.github.johnrengelman.shadow") version "8.1.1"
	id("io.micronaut.library") version "4.5.3"
	id("io.micronaut.application") version "4.5.3"
}

repositories { mavenCentral() }

dependencies {
	implementation(project(":launcher"))
	implementation(project(":engine"))
	implementation(project(":core"))
	implementation(project(":plugins"))
}

application { mainClass = "io.github.alemazzo.architect.launcher.ArchitectLauncher" }

micronaut {
	testRuntime("junit5")
	processing {
		incremental(true)
		annotations("io.github.alemazzo.architect.*")
	}
}

// Architect

java {
	sourceCompatibility = JavaVersion.toVersion("17")
}

kotlin {
	jvmToolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
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

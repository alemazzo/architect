val kotlinVersion = project.properties["kotlinVersion"] as String? ?: "1.9.24"

version = "4.23.5"

group = "io.github.alemazzo.architect"

plugins {
	id("org.jetbrains.kotlin.jvm")
	id("org.jetbrains.kotlin.kapt")
	id("org.jetbrains.kotlin.plugin.allopen")
	id("com.github.johnrengelman.shadow")
	id("io.micronaut.library")
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


micronaut {
	testRuntime("junit5")
	processing {
		incremental(true)
		annotations("io.github.alemazzo.architect.engine.*")
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

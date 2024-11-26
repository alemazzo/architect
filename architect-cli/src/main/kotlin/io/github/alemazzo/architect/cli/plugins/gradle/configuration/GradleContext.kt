package io.github.alemazzo.architect.cli.plugins.gradle.configuration

data class ProjectContext(
	val name: String,
	var path: String?,
	val command: String = "./gradlew",
)


data class GradleContext(
	val projects: List<ProjectContext> = emptyList(),
)


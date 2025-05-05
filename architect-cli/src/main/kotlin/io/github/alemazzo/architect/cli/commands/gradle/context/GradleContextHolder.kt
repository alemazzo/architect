package io.github.alemazzo.architect.cli.commands.gradle.context

data class ProjectContext(
	val name: String,
	var path: String?,
	val command: String = "./gradlew",
)

data class GradleContext(
	val projects: List<ProjectContext> = emptyList(),
)

data class GradleContextHolder(
	val gradle: GradleContext? = null,
)


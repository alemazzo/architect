package io.github.alemazzo.architect.plugins.gradle.context

data class ProjectContext(
	val name: String,
	var path: String?,
	val command: String = "./gradlew",
	val githubPackageRelease: Boolean = false,
)

data class GradleContext(
	val projects: List<ProjectContext> = emptyList(),
)

data class GradleContextHolder(
	val gradle: GradleContext? = null,
)


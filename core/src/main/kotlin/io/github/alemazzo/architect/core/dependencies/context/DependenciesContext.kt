package io.github.alemazzo.architect.core.dependencies.context

data class DepsContext(
	val type: String = "dependencies/renovate",
	val format: String = "json",
)

data class DependenciesContext(
	val deps: DepsContext = DepsContext()
)
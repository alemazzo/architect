package io.github.alemazzo.architect.cli.commands.dependencies.context

data class DepsContext(
	val type: String = "renovate",
	val format: String = "json",
)

data class DependenciesContext(
	val deps: DepsContext = DepsContext()
)
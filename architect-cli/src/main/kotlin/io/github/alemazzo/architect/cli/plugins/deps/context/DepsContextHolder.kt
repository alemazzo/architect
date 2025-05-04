package io.github.alemazzo.architect.cli.plugins.deps.context

data class DepsContext(
	val type: String = "renovate",
	val format: String = "json",
)

data class DepsContextHolder(
	val deps: DepsContext = DepsContext()
)
package io.github.alemazzo.architect.cli.plugins.architect

data class ArchitectConfiguration(
	val name: String = "",
	val description: String = "",
	val plugins: List<String> = emptyList(),
)


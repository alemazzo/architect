package io.github.alemazzo.architect.cli.plugins.semantic.release.configuration

data class SemanticReleaseContext(
	val path: String = ".architect/plugins/semantic-release",
	val command: String = "./release",
	val assets: List<Asset> = emptyList(),
)
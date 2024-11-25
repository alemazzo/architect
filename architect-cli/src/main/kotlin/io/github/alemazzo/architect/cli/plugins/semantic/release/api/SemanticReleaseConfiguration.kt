package io.github.alemazzo.architect.cli.plugins.semantic.release.api

import com.fasterxml.jackson.annotation.JsonProperty

data class Asset(val path: String, val name: String)

data class SemanticReleaseConfiguration(
	val path: String = ".architect/plugins/semantic-release",
	val command: String = "./release",
	val assets: List<Asset> = emptyList(),
)



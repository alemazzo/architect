package io.github.alemazzo.architect.cli.plugins.semantic.release.context

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ReleasesContext(
	val release: ReleaseContext = ReleaseContext(),
)

@Serdeable
data class ReleaseContext(
	val message: String = "chore(release): \${nextRelease.version} [skip ci]",
	val assets: List<Asset> = listOf(),
	val git_assets: List<String> = emptyList(),
)

@Serdeable
data class Asset(
	val name: String,
	val path: String,
)

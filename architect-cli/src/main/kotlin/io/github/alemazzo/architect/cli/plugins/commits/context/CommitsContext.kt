package io.github.alemazzo.architect.cli.plugins.commits.context

data class CommitsContext(
	val path: String = ".phases/plugins/conventional-commits",
	val command: String = "./gradlew",
)
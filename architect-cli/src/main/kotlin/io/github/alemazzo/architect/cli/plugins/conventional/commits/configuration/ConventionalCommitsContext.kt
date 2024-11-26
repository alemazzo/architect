package io.github.alemazzo.architect.cli.plugins.conventional.commits.configuration

data class ConventionalCommitsContext(
	val path: String = ".architect/plugins/conventional-commits",
	val command: String = "./gradlew",
)
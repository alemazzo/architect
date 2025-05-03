package io.github.alemazzo.architect.cli.plugins.plugins.registries.github

data class GithubPluginConfiguration(
	val owner: String,
	val name: String,
	val jar: String,
	val loadClass: String,
)

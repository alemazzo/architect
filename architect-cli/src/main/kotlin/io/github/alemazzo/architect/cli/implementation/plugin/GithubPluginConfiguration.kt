package io.github.alemazzo.architect.cli.implementation.plugin

data class GithubPluginConfiguration(
	val owner: String,
	val repo: String,
	val jar: String,
	val loadClass: String,
)

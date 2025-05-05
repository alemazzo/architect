package io.github.alemazzo.architect.cli.engine.plugins.application.executors.github

data class GithubPluginConfiguration(
	val owner: String,
	val name: String,
	val jar: String,
	val loadClass: String,
)

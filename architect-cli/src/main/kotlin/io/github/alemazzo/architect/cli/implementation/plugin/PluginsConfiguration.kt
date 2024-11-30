package io.github.alemazzo.architect.cli.implementation.plugin

data class PluginsConfiguration(
	val plugins: List<GithubPluginConfiguration> = emptyList(),
)


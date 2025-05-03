package io.github.alemazzo.architect.cli.plugins.plugins.context

import io.github.alemazzo.architect.cli.plugins.plugins.registries.github.GithubPluginConfiguration

data class PluginsContext(
	val plugins: List<GithubPluginConfiguration> = emptyList(),
)


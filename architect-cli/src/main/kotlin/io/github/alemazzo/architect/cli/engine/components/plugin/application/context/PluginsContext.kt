package io.github.alemazzo.architect.cli.engine.components.plugin.application.context

import io.github.alemazzo.architect.cli.engine.components.plugin.application.executors.github.GithubPluginConfiguration

data class PluginsContext(
	val plugins: List<GithubPluginConfiguration> = emptyList(),
)


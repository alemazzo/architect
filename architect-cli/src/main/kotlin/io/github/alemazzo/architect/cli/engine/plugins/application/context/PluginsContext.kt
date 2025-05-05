package io.github.alemazzo.architect.cli.engine.plugins.application.context

import io.github.alemazzo.architect.cli.engine.plugins.application.executors.github.GithubPluginConfiguration

data class PluginsContext(
	val plugins: List<GithubPluginConfiguration> = emptyList(),
)


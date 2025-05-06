package io.github.alemazzo.architect.engine.plugins.application.context

import io.github.alemazzo.architect.engine.plugins.application.executors.github.GithubPluginConfiguration

data class PluginsContext(
	val plugins: List<GithubPluginConfiguration> = emptyList(),
)


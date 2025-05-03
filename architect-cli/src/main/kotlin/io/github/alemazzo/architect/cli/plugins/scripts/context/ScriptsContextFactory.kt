package io.github.alemazzo.architect.cli.plugins.scripts.context

import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.api.plugin.PluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ScriptsContextFactory : PluginContextFactory() {
	@Singleton
	fun getScriptsContext(context: Context): ScriptsContext = getContext(context)
}
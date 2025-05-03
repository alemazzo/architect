package io.github.alemazzo.architect.cli.plugins.plugins.context

import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.api.plugin.PluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class PluginsContextFactory : PluginContextFactory() {

	@Singleton
	fun create(context: Context): PluginsContext = getContext(context)

}
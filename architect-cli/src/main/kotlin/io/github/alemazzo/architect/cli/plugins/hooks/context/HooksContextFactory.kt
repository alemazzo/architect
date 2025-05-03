package io.github.alemazzo.architect.cli.plugins.hooks.context

import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.api.plugin.PluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class HooksContextFactory : PluginContextFactory() {
	@Singleton
	fun getHooksContext(context: Context): HooksContext = getContext(context)
}
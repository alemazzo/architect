package io.github.alemazzo.architect.cli.plugins.hooks.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.components.plugin.api.AbstractPluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class HooksContextFactoryAbstract : AbstractPluginContextFactory() {
	@Singleton
	fun getHooksContext(context: Context): HooksContext = getContext(context)
}
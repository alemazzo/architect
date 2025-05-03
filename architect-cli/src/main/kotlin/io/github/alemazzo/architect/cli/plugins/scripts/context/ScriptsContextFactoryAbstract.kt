package io.github.alemazzo.architect.cli.plugins.scripts.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.components.plugin.api.AbstractPluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ScriptsContextFactoryAbstract : AbstractPluginContextFactory() {
	@Singleton
	fun getScriptsContext(context: Context): ScriptsContext = getContext(context)
}
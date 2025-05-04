package io.github.alemazzo.architect.cli.engine.components.plugin.application.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class PluginsContextFactoryAbstract : AbstractContextFactory() {

	@Singleton
	fun create(context: Context): PluginsContext = getContext(context)

}
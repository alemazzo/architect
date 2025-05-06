package io.github.alemazzo.architect.engine.plugins.application.context

import io.github.alemazzo.architect.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class PluginsContextFactoryAbstract : AbstractContextFactory<PluginsContext>() {

	@Singleton
	override fun create(): PluginsContext = getContext()

}
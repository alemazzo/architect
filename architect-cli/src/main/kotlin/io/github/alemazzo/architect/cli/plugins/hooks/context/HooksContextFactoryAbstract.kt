package io.github.alemazzo.architect.cli.plugins.hooks.context

import io.github.alemazzo.architect.cli.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class HooksContextFactoryAbstract : AbstractContextFactory<HooksContext>() {
	@Singleton
	override fun create(): HooksContext = getContext()
}
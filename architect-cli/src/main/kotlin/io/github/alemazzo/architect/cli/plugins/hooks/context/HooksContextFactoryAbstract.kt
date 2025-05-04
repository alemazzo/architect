package io.github.alemazzo.architect.cli.plugins.hooks.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class HooksContextFactoryAbstract : AbstractContextFactory() {
	@Singleton
	fun getHooksContext(context: Context): HooksContext = getContext(context)
}
package io.github.alemazzo.architect.cli.plugins.scripts.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ScriptsContextFactory : AbstractContextFactory() {
	@Singleton
	fun getScriptsContext(context: Context): ScriptsContext = getContext(context)
}
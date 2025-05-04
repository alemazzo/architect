package io.github.alemazzo.architect.cli.plugins.deps.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.components.plugin.api.AbstractPluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class DepsContextFactory : AbstractPluginContextFactory() {
	@Singleton
	fun getDepsContext(context: Context): DepsContextHolder = getContext(context)
}
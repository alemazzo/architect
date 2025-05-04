package io.github.alemazzo.architect.cli.plugins.deps.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class DepsContextFactory : AbstractContextFactory() {
	@Singleton
	fun getDepsContext(context: Context): DepsContextHolder = getContext(context)
}
package io.github.alemazzo.architect.cli.plugins.deps.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class DepsContextFactory : AbstractContextFactory<DepsContextHolder>() {
	@Singleton
	override fun create(): DepsContextHolder = getContext()
}
package io.github.alemazzo.architect.core.dependencies.context

import io.github.alemazzo.architect.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class DependenciesContextFactory : AbstractContextFactory<DependenciesContext>() {
	@Singleton
	override fun create(): DependenciesContext = getContext()
}
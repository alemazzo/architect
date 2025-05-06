package io.github.alemazzo.architect.core.scripts.context

import io.github.alemazzo.architect.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ScriptsContextFactory : AbstractContextFactory<ScriptsContext>() {
	@Singleton
	override fun create(): ScriptsContext = getContext()
}
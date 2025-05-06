package io.github.alemazzo.architect.core.pipelines.context

import io.github.alemazzo.architect.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class PipelinesContextFactory : AbstractContextFactory<PipelinesContextHolder>() {
	@Singleton
	override fun create(): PipelinesContextHolder = getContext()
}
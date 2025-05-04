package io.github.alemazzo.architect.cli.plugins.pipelines.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class PipelinesContextFactory : AbstractContextFactory<PipelinesContextHolder>() {
	@Singleton
	override fun create(): PipelinesContextHolder = getContext()
}
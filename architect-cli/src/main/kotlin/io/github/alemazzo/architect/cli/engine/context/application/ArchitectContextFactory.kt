package io.github.alemazzo.architect.cli.engine.context.application

import io.github.alemazzo.architect.cli.engine.context.api.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.context.api.ArchitectContext
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
@Singleton
class ArchitectContextFactory: AbstractContextFactory<ArchitectContext>() {
	@Singleton
	override fun create(): ArchitectContext = getContext()
}
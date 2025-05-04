package io.github.alemazzo.architect.cli.engine.applications.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.api.context.ArchitectContext
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
@Singleton
class ArchitectContextFactory: AbstractContextFactory<ArchitectContext>() {
	@Singleton
	override fun create(): ArchitectContext = getContext()
}
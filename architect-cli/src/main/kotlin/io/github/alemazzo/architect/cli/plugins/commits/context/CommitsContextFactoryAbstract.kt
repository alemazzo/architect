package io.github.alemazzo.architect.cli.plugins.commits.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class CommitsContextFactoryAbstract : AbstractContextFactory<CommitsContext>() {
	@Singleton
	override fun create(): CommitsContext = getContext()
}
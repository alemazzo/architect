package io.github.alemazzo.architect.cli.plugins.releases.context

import io.github.alemazzo.architect.cli.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ReleasesContextFactory : AbstractContextFactory<ReleasesContext>() {
	@Singleton
	override fun create(): ReleasesContext = getContext()
}
package io.github.alemazzo.architect.cli.plugins.releases.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.components.plugin.api.AbstractPluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ReleasesContextFactory : AbstractPluginContextFactory() {
	@Singleton
	fun getReleaseContext(context: Context): ReleasesContext = getContext(context)
}
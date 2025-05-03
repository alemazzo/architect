package io.github.alemazzo.architect.cli.plugins.commits.context

import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.api.plugin.PluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class CommitsContextFactory : PluginContextFactory() {
	@Singleton
	fun getCommitsContext(context: Context): CommitsContext = getContext(context)
}
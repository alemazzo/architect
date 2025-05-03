package io.github.alemazzo.architect.cli.plugins.commits.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.components.plugin.api.AbstractPluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class CommitsContextFactoryAbstract : AbstractPluginContextFactory() {
	@Singleton
	fun getCommitsContext(context: Context): CommitsContext = getContext(context)
}
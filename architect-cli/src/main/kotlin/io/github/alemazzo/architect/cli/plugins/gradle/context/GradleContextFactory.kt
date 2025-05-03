package io.github.alemazzo.architect.cli.plugins.gradle.context

import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.api.plugin.PluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class GradleContextFactory : PluginContextFactory() {
	@Singleton
	fun createContext(context: Context): GradleContext = getContext(context)
}



package io.github.alemazzo.architect.cli.plugins.gradle.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.components.plugin.api.AbstractPluginContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class GradleContextFactory : AbstractPluginContextFactory() {
	@Singleton
	fun createContext(context: Context): GradleContextHolder = getContext(context)
}



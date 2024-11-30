package io.github.alemazzo.architect.cli.implementation.plugin

import io.github.alemazzo.architect.cli.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class PluginsConfigurationFactory {

	@Singleton
	fun create(context: Context): PluginsConfiguration {
		return context.of<PluginsConfiguration>() ?: PluginsConfiguration()
	}

}
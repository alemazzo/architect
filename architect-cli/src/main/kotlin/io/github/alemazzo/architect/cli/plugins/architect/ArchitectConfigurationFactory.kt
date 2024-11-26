package io.github.alemazzo.architect.cli.plugins.architect

import io.github.alemazzo.architect.cli.api.annotation.utils.Announcer
import io.github.alemazzo.architect.cli.context.Context
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class ArchitectConfigurationFactory {

	@Bean
	fun getArchitectConfiguration(context: Context?): ArchitectConfiguration {
		return context?.ofThisPlugin() ?: ArchitectConfiguration()
	}

	@Announcer
	class ArchitectConfigurationAnnouncer(configuration: ArchitectConfiguration) {
		init {
			println("Architect Configuration: $configuration")
		}
	}

}
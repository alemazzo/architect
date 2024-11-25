package io.github.alemazzo.architect.cli.plugins.architect

import io.github.alemazzo.architect.cli.api.annotation.utils.Announcer
import io.github.alemazzo.architect.cli.api.annotation.utils.PrimaryCreator
import io.github.alemazzo.architect.cli.configuration.Configuration
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class ArchitectConfigurationFactory {

	@Bean
	fun getDefault(): ArchitectConfiguration {
		return ArchitectConfiguration()
	}

	@Bean
	@PrimaryCreator
	fun getArchitectConfiguration(configuration: Configuration): ArchitectConfiguration? {
		return configuration.parse()
	}

	@Announcer
	class ArchitectConfigurationAnnouncer(private val configuration: ArchitectConfiguration) {
		init {
			println("Architect Configuration: $configuration")
		}
	}

}
package io.github.alemazzo.architect.cli.plugins.architect

import io.github.alemazzo.architect.cli.configuration.Configuration
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Primary

@Factory
class ArchitectConfigurationFactory {

	@Bean
	fun getDefault(): ArchitectConfiguration {
		return ArchitectConfiguration()
	}

	@Bean
	@Primary
	fun getArchitectConfiguration(configuration: Configuration): ArchitectConfiguration? {
		return configuration.parse()
	}

	@Context
	class Announcer(private val configuration: ArchitectConfiguration) {
		init {
			println("Architect Configuration: $configuration")
		}
	}

}
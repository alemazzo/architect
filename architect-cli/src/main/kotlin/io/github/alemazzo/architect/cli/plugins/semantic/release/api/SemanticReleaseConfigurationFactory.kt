package io.github.alemazzo.architect.cli.plugins.semantic.release.api

import io.github.alemazzo.architect.cli.configuration.Configuration
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Factory

@Factory
class SemanticReleaseConfigurationFactory {

	@Bean
	fun getSemanticReleaseConfiguration(
		configuration: Configuration,
	): SemanticReleaseConfiguration {
		return configuration.parse<SemanticReleaseConfiguration.Yaml>().semanticRelease
	}

	@Context
	class Announcer(private val configuration: SemanticReleaseConfiguration) {
		init {
			println("Semantic Release Configuration: $configuration")
		}
	}

}
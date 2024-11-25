package io.github.alemazzo.architect.cli.plugins.semantic.release.api

import io.github.alemazzo.architect.cli.api.annotation.utils.Announcer
import io.github.alemazzo.architect.cli.configuration.Configuration
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Primary


@Factory
class SemanticReleaseConfigurationFactory {

	@Bean
	fun getDefault(): SemanticReleaseConfiguration {
		return SemanticReleaseConfiguration()
	}

	@Bean
	@Primary
	fun getSemanticReleaseConfiguration(
		configuration: Configuration,
	): SemanticReleaseConfiguration? {
		return configuration.parse<SemanticReleaseConfiguration.Yaml>()?.semanticRelease
	}

	@Announcer
	class SemanticReleaseAnnouncer(private val configuration: SemanticReleaseConfiguration) {
		init {
			println("Semantic Release Configuration: $configuration")
		}
	}

}
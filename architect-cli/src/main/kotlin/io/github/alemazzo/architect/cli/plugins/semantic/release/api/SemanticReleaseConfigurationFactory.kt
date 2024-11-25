package io.github.alemazzo.architect.cli.plugins.semantic.release.api

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.annotation.utils.Announcer
import io.github.alemazzo.architect.cli.configuration.Configuration
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory


@Factory
class SemanticReleaseConfigurationFactory {

	class YamlConfiguration {
		@JsonProperty("semantic-release")
		val configuration: SemanticReleaseConfiguration = SemanticReleaseConfiguration()
	}

	@Bean
	fun getSemanticReleaseConfiguration(
		configuration: Configuration,
	): SemanticReleaseConfiguration {
		return configuration.parse<YamlConfiguration>()?.configuration ?: SemanticReleaseConfiguration()
	}

	@Announcer
	class SemanticReleaseAnnouncer(configuration: SemanticReleaseConfiguration) {
		init {
			println("Semantic Release Configuration: $configuration")
		}
	}

}
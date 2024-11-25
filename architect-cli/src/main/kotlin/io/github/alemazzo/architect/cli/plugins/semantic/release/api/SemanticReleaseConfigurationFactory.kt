package io.github.alemazzo.architect.cli.plugins.semantic.release.api

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class SemanticReleaseConfigurationFactory {

	@Bean
	fun create(): SemanticReleaseConfiguration {
		return SemanticReleaseConfiguration()
	}

}
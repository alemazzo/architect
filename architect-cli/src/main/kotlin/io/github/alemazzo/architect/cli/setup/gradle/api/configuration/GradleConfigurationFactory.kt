package io.github.alemazzo.architect.cli.setup.gradle.api.configuration

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class GradleConfigurationFactory {

	@Bean
	fun create(): GradleConfiguration {
		return GradleConfiguration()
	}

}
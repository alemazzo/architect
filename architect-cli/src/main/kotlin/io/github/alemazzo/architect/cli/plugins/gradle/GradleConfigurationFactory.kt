package io.github.alemazzo.architect.cli.plugins.gradle

import io.github.alemazzo.architect.cli.api.annotation.utils.Announcer
import io.github.alemazzo.architect.cli.configuration.Configuration
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class GradleConfigurationFactory {

	class YamlGradleConfiguration(
		val gradle: GradleConfiguration = GradleConfiguration(),
	)

	@Bean
	fun getGradleConfiguration(configuration: Configuration?): GradleConfiguration {
		return configuration?.parse<YamlGradleConfiguration>()?.gradle ?: GradleConfiguration()
	}

	@Announcer
	class GradleConfigurationAnnouncer(configuration: GradleConfiguration) {
		init {
			println("Gradle Configuration: $configuration")
		}
	}
}
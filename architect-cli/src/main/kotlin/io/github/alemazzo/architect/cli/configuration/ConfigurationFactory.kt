package io.github.alemazzo.architect.cli.configuration

import io.github.alemazzo.architect.cli.api.annotation.utils.Announcer
import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import java.io.File

@Factory
class ConfigurationFactory {

	@Bean
	@Requires(resources = ["architect.yml"])
	fun getExternalConfiguration(parser: ConfigurationParser): Configuration? {
		val file = File("architect.yml")
		if (!file.exists()) return null
		return Configuration(parser, file.readText())
	}

	@Announcer
	class ConfigurationAnnouncer(configuration: Configuration?) {
		init {
			if (configuration != null) {
				println("Configuration: $configuration")
			} else {
				println("No configuration found")
			}
		}
	}

}
package io.github.alemazzo.architect.cli.configuration

import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import java.io.File

@Factory
class ConfigurationFactory {

	@Bean
	fun getDefault(parser: ConfigurationParser): Configuration {
		return Configuration(parser)
	}

	@Bean
	@Primary
	@Requires(notEnv = ["test"])
	fun getExternalConfiguration(parser: ConfigurationParser): Configuration? {
		val file = File("architect.yml")
		if (!file.exists()) return null
		return Configuration(parser, file.readText())
	}

}
package io.github.alemazzo.architect.cli.context

import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser
import io.github.alemazzo.architect.cli.plugins.architect.ArchitectConfiguration
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class ConfigurationParserTest(
	val architectConfigurationParser: ConfigurationParser,
) {

	@Test
	fun parseEmptyConfigurations() {
		val configurations = architectConfigurationParser.parse<ArchitectConfiguration>("")
		assert(configurations == null)
	}

	@Test
	fun parseConfigurations() {
		val configurations =
			architectConfigurationParser.parse<ArchitectConfiguration>(
				"""
            name: "Architect"
            description: "A Micronaut CLI"
            plugins:
              - "io.github.alemazzo.architect.cli.plugins.architect.ArchitectConfigurator"
            """
					.trimIndent()
			)!!
		assert(configurations.name == "Architect")
		assert(configurations.description == "A Micronaut CLI")
		assert(configurations.plugins.size == 1)
		assert(
			configurations.plugins[0] ==
					"io.github.alemazzo.architect.cli.plugins.architect.ArchitectConfigurator"
		)
	}

	@Test
	fun parsePartialConfigurations() {
		val configurations =
			architectConfigurationParser.parse<ArchitectConfiguration>(
				"""
			name: "Architect"
			plugins:
			  - "io.github.alemazzo.architect.cli.plugins.architect.ArchitectConfigurator"
			"""
					.trimIndent()
			)!!
		assert(configurations.name == "Architect")
		assert(configurations.description == "")
		assert(configurations.plugins.size == 1)
		assert(
			configurations.plugins[0] ==
					"io.github.alemazzo.architect.cli.plugins.architect.ArchitectConfigurator"
		)
	}
}

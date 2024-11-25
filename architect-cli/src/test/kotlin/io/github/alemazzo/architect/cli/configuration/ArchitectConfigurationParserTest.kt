package io.github.alemazzo.architect.cli.configuration

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class ArchitectConfigurationParserTest(
	val architectConfigurationParser: ArchitectConfigurationParser,
) {

	@Test
	fun parseEmptyConfigurations() {
		val configurations = architectConfigurationParser.parse("")
		assert(configurations.name == "")
		assert(configurations.description == "")
		assert(configurations.plugins.isEmpty())
	}

	@Test
	fun parseConfigurations() {
		val configurations =
			architectConfigurationParser.parse(
				"""
            name: "Architect"
            description: "A Micronaut CLI"
            plugins:
              - "io.github.alemazzo.architect.cli.configuration.ArchitectConfigurator"
            """
					.trimIndent()
			)
		assert(configurations.name == "Architect")
		assert(configurations.description == "A Micronaut CLI")
		assert(configurations.plugins.size == 1)
		assert(
			configurations.plugins[0] ==
					"io.github.alemazzo.architect.cli.configuration.ArchitectConfigurator"
		)
	}

	@Test
	fun parsePartialConfigurations() {
		val configurations =
			architectConfigurationParser.parse(
				"""
			name: "Architect"
			plugins:
			  - "io.github.alemazzo.architect.cli.configuration.ArchitectConfigurator"
			"""
					.trimIndent()
			)
		assert(configurations.name == "Architect")
		assert(configurations.description == "")
		assert(configurations.plugins.size == 1)
		assert(
			configurations.plugins[0] ==
					"io.github.alemazzo.architect.cli.configuration.ArchitectConfigurator"
		)
	}
}

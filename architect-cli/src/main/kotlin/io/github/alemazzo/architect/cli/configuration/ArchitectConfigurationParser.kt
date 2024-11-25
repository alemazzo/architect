package io.github.alemazzo.architect.cli.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.github.alemazzo.architect.cli.api.annotation.Component

@Component
class ArchitectConfigurationParser {

	private val objectMapper =
		ObjectMapper(YAMLFactory()).registerModules(KotlinModule.Builder().build())

	fun parse(content: String): ArchitectConfiguration {
		if (content.isEmpty()) {
			return ArchitectConfiguration()
		}
		return objectMapper.readValue(content, ArchitectConfiguration::class.java)
	}
}
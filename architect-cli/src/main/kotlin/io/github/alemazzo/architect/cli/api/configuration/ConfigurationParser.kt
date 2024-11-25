package io.github.alemazzo.architect.cli.api.configuration

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.github.alemazzo.architect.cli.api.annotation.Component

@Component
class ConfigurationParser {

	val objectMapper: ObjectMapper =
		ObjectMapper(YAMLFactory()).registerModules(KotlinModule.Builder().build())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

	inline fun <reified T> parse(content: String): T {
		if (content.isEmpty()) {
			return T::class.java.getDeclaredConstructor().newInstance()
		}
		return objectMapper.readValue(content, T::class.java)
	}
}
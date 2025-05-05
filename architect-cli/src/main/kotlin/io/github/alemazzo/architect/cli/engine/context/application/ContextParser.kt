package io.github.alemazzo.architect.cli.engine.context.application

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import jakarta.inject.Singleton

@Singleton
class ContextParser {

	val objectMapper: ObjectMapper =
		ObjectMapper(YAMLFactory()).registerModules(KotlinModule.Builder().build())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

	inline fun <reified T> parse(content: String): T? {
		if (content.isEmpty()) {
			return null
		}
		return objectMapper.readValue(content, T::class.java)
	}
}

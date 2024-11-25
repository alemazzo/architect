package io.github.alemazzo.architect.cli.configuration

import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser

class Configuration(val configurationParser: ConfigurationParser, val raw: String = "") {

	inline fun <reified T> parse(): T? {
		return try {
			configurationParser.parse<T>(raw)
		} catch (e: Exception) {
			null
		}
	}
}


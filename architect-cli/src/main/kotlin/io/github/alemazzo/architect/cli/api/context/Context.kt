package io.github.alemazzo.architect.cli.api.context

import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser

data class Context(val raw: String = "") {

	val configurationParser = ConfigurationParser()

	inline fun <reified C> of(): C? = configurationParser.parse(raw)

}


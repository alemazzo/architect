package io.github.alemazzo.architect.cli.api.context

import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser

open class Context(val context: String = "") {

	val configurationParser = ConfigurationParser()

	inline fun <reified C> of(): C? = configurationParser.parse(context)

}


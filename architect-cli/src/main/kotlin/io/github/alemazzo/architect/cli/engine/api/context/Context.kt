package io.github.alemazzo.architect.cli.engine.api.context

import io.github.alemazzo.architect.cli.engine.applications.context.ContextParser


open class Context(val context: String = "") {

	val contextParser = ContextParser()

	inline fun <reified C> of(): C? = contextParser.parse(context)

}


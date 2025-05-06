package io.github.alemazzo.architect.engine.context.api

import io.github.alemazzo.architect.engine.context.application.ContextParser

open class Context(val context: String = "") {

	val contextParser = ContextParser()

	inline fun <reified C> of(): C? = contextParser.parse(context)

}


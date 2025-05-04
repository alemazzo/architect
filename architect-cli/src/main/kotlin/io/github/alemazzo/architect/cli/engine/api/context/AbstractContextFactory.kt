package io.github.alemazzo.architect.cli.engine.api.context

import io.github.alemazzo.architect.cli.engine.api.log.getLogger


abstract class AbstractContextFactory {

	val logger = getLogger()

	inline fun <reified T> getContext(context: Context): T {
		logger.info("Loading context of type ${T::class.simpleName}")
		val createdContext = context.of<T>() ?: T::class.java.getDeclaredConstructor().newInstance()
		logger.info("Context loaded: $createdContext")
		return createdContext
	}

}
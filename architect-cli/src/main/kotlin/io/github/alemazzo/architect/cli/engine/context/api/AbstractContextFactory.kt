package io.github.alemazzo.architect.cli.engine.context.api

import io.github.alemazzo.architect.cli.engine.utils.log.getLogger
import jakarta.inject.Inject


abstract class AbstractContextFactory<T> {

	@Inject
	lateinit var context: Context

	val logger = getLogger()

	inline fun <reified T> getContext(): T {
		logger.info("Loading context of type ${T::class.simpleName}")
		val createdContext = context.of<T>() ?: T::class.java.getDeclaredConstructor().newInstance()
		logger.info("Context loaded: $createdContext")
		return createdContext
	}

	abstract fun create(): T

}
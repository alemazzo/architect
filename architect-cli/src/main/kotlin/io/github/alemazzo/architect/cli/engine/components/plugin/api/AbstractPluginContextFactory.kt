package io.github.alemazzo.architect.cli.engine.components.plugin.api

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.api.log.getLogger


abstract class AbstractPluginContextFactory {

	val logger = getLogger()

	inline fun <reified T> getContext(context: Context): T {
		logger.info("Loading context of type ${this::class.simpleName}")
		return context.of<T>() ?: T::class.java.getDeclaredConstructor().newInstance()
	}

}
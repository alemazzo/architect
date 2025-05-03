package io.github.alemazzo.architect.cli.api.plugin

import io.github.alemazzo.architect.cli.api.Architect
import io.github.alemazzo.architect.cli.api.context.Context


abstract class PluginContextFactory : Architect {

	inline fun <reified T> getContext(context: Context): T {
		logger.info("Loading context of type ${this::class.simpleName}")
		return context.of<T>() ?: T::class.java.getDeclaredConstructor().newInstance()
	}

}
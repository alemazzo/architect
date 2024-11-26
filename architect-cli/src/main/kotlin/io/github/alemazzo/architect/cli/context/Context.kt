package io.github.alemazzo.architect.cli.context

import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.api.configuration.ConfigurationParser
import io.micronaut.context.annotation.Requires

data class Context(val raw: String = "") {

	val configurationParser = ConfigurationParser()

	inline fun <reified T> of(): T? = configurationParser.parse<T>(raw)

	inline fun <reified T : Plugin<C>, C> ofThisPlugin(): C? =
		configurationParser.parse<T>(raw)?.context
}

@Requires(bean = Context::class)
annotation class RequireContext


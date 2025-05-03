package io.github.alemazzo.architect.cli.plugins.plugins

import io.github.alemazzo.architect.cli.api.log.WithLogger
import io.github.alemazzo.architect.cli.api.plugin.BasicPlugin
import io.github.alemazzo.architect.cli.plugins.plugins.registries.github.GithubPluginRegistry
import io.micronaut.core.annotation.Order
import io.micronaut.core.order.Ordered
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
class PluginRegistry(
	private val contextedPlugins: MutableList<BasicPlugin>,
	private val githubPluginRegistry: GithubPluginRegistry,
) : WithLogger {

	fun register(commandLine: CommandLine) {
		githubPluginRegistry.getAll().forEach {
			contextedPlugins.add(it)
		}
		contextedPlugins.forEach { logger.info("Plugin: ${it.name}") }
		contextedPlugins
			.sortedBy { getOrder(it) }
			.forEach { it.plug(commandLine) }
	}

	private fun getOrder(service: Any): Int {
		// Check if the service implements Ordered
		if (service is Ordered) {
			return service.order
		}
		// Retrieve @Order annotation if present
		val orderAnnotation = service::class.annotations.find { it is Order } as? Order
		if (orderAnnotation != null) {
			return orderAnnotation.value
		}
		// Default to a low priority
		return Int.MAX_VALUE
	}

}


package io.github.alemazzo.architect.cli.plugins

import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.utils.log.WithLogger
import io.micronaut.core.annotation.Order
import io.micronaut.core.order.Ordered
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
class PluginRegistry(private val plugins: List<Plugin<*>>) : WithLogger {
	fun register(commandLine: CommandLine) {
		plugins.forEach { logger.info("Plugin: ${it.name}") }
		plugins
			.sortedBy { getOrder(it) }
			.forEach {
				logger.info("Registering plugin: ${it.name}")
				it.plug(commandLine)
			}
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
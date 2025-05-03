package io.github.alemazzo.architect.cli.engine.applications.components

import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent
import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.micronaut.core.annotation.Order
import io.micronaut.core.order.Ordered
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
class EngineComponentRegistry(
	private val components: MutableList<EngineComponent>,
) {
	private val logger = getLogger()

	fun register(commandLine: CommandLine) {
		components.forEach { logger.debug("Plugin: ${it.name}") }
		components
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


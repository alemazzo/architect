package io.github.alemazzo.architect.engine.command.application

import io.github.alemazzo.architect.engine.command.api.Command
import io.github.alemazzo.architect.engine.utils.log.getLogger
import io.micronaut.core.annotation.Order
import io.micronaut.core.order.Ordered
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
class CommandRegistry(
	private val commands: MutableList<Command>,
) {
	private val logger = getLogger()

	fun register(commandLine: CommandLine) {
		commands.forEach { logger.debug("Command: ${it.name}") }
		commands
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


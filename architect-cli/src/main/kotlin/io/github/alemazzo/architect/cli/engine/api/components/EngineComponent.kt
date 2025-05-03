package io.github.alemazzo.architect.cli.engine.api.components

import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import picocli.CommandLine

abstract class EngineComponent(val name: String) : Runnable {

	private val logger = getLogger()

	override fun run() {
		logger.debug("Running Plugin Usage: $name")
		CommandLine.usage(this, System.out)
	}

	open fun plug(commandLine: CommandLine) {
		logger.debug("Registering plugin: $name")
		commandLine.addSubcommand(name, this)
	}
}
package io.github.alemazzo.architect.cli.engine.components.plugin.api

import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent
import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import picocli.CommandLine

abstract class Plugin<Config>(override val name: String) : EngineComponent {
	private val logger = getLogger()

	override fun run() {
		logger.debug("Running Plugin Usage: $name")
		CommandLine.usage(this, System.out)
	}

	override fun plug(commandLine: CommandLine) {
		logger.debug("Registering plugin: $name")
		commandLine.addSubcommand(name, this)
	}
}

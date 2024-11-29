package io.github.alemazzo.architect.cli.api.plugin

import io.github.alemazzo.architect.cli.utils.log.WithLogger
import picocli.CommandLine

abstract class Plugin<Config>(val name: String) : Runnable, WithLogger {
	abstract val context: Config?

	override fun run() {
		logger.info("Running Plugin Usage: $name")
		CommandLine.usage(this, System.out)
	}

	open fun plug(commandLine: CommandLine) {
		logger.info("Registering plugin: $name")
		commandLine.addSubcommand(name, this)
	}
}

package io.github.alemazzo.architect.cli.api.plugin

import picocli.CommandLine

abstract class Plugin<Config>(name: String) : BasicPlugin(name) {
	abstract val context: Config?

	override fun run() {
		logger.info("Running Plugin Usage: $name")
		CommandLine.usage(this, System.out)
	}

	override fun plug(commandLine: CommandLine) {
		logger.info("Registering plugin: $name")
		commandLine.addSubcommand(name, this)
	}
}

package io.github.alemazzo.architect.cli.engine.api.components

import picocli.CommandLine

interface EngineComponent : Runnable {
	val name: String

	override fun run() {
		CommandLine.usage(this, System.out)
	}

	fun plug(commandLine: CommandLine) {
		commandLine.addSubcommand(name, this)
	}
}
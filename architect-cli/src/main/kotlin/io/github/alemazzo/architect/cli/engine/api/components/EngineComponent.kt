package io.github.alemazzo.architect.cli.engine.api.components

import io.github.alemazzo.architect.cli.engine.api.ArchitectTask
import picocli.CommandLine

abstract class EngineComponent(val name: String) : ArchitectTask {

	override fun run() {
		println("Engine $name")
		CommandLine.usage(this, System.out)
	}

	open fun plug(commandLine: CommandLine) {
		commandLine.addSubcommand(name, this)
	}
}
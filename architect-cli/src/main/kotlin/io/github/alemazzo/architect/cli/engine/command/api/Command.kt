package io.github.alemazzo.architect.cli.engine.command.api

import picocli.CommandLine

abstract class Command(val name: String) : AbstractCommand {

	var commandLine: CommandLine? = null
		private set

	override fun run() {
		println("Engine $name")
		CommandLine.usage(this, System.out)
	}

	open fun plug(commandLine: CommandLine) {
		this.commandLine = commandLine
		commandLine.addSubcommand(name, this)
	}
}
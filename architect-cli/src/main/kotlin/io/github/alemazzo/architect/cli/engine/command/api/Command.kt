package io.github.alemazzo.architect.cli.engine.command.api

import picocli.CommandLine

abstract class Command(val name: String) : AbstractCommand {

	override fun run() {
		println("Engine $name")
		CommandLine.usage(this, System.out)
	}

	open fun plug(commandLine: CommandLine) {
		commandLine.addSubcommand(name, this)
	}
}
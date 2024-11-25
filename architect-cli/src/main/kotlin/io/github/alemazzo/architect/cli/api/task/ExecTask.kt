package io.github.alemazzo.architect.cli.api.task

import io.github.alemazzo.architect.cli.utils.CommandExecutor

open class ExecTask(val configuration: ExecConfiguration, val commandExecutor: CommandExecutor) : Runnable {
	override fun run() {
		println("Executing command: ${configuration.command} on path: ${configuration.path}")
		commandExecutor.execute(configuration.command, configuration.path)
	}
}

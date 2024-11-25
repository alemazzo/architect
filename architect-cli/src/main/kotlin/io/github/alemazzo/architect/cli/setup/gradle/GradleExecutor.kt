package io.github.alemazzo.architect.cli.setup.gradle

import io.github.alemazzo.architect.cli.api.annotation.Component
import io.github.alemazzo.architect.cli.utils.CommandExecutor

@Component
class GradleExecutor(
	private val configuration: GradleExecutorConfiguration,
	private val commandExecutor: CommandExecutor,
) {

	private fun getCommand(args: Array<String>): String {
		return "${configuration.command} ${args.joinToString(" ")}"
	}

	fun execute(args: Array<String>): Boolean {
		val command = getCommand(args)
		return commandExecutor.execute(command)
	}
}
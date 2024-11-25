package io.github.alemazzo.architect.cli.plugins.gradle.api

import io.github.alemazzo.architect.cli.api.annotation.Component
import io.github.alemazzo.architect.cli.plugins.gradle.api.configuration.GradleConfiguration
import io.github.alemazzo.architect.cli.utils.CommandExecutor

@Component
class GradleExecutor(
	private val configuration: GradleConfiguration,
	private val commandExecutor: CommandExecutor,
) {

	private fun getCommand(args: Array<String>): String {
		return "${configuration.command} ${args.joinToString(" ")}"
	}

	fun execute(args: Array<String>): Boolean {
		if (configuration.mock) {
			println("Mocking Gradle execution")
			return true
		}
		println("Executing Gradle command: ${getCommand(args)} on path: ${configuration.path}")
		return commandExecutor.execute(getCommand(args), configuration.path)
	}
}
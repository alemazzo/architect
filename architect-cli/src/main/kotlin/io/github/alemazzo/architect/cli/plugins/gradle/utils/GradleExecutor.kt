package io.github.alemazzo.architect.cli.plugins.gradle.utils

import io.github.alemazzo.architect.cli.plugins.gradle.GradlePlugin
import io.github.alemazzo.architect.cli.plugins.gradle.configuration.GradleContext
import io.github.alemazzo.architect.cli.utils.CommandExecutor
import jakarta.inject.Singleton

@Singleton
@GradlePlugin
class GradleExecutor(
	private val configuration: GradleContext,
	private val commandExecutor: CommandExecutor,
) {

	private fun getCommand(args: Array<String>): String {
		return "./${configuration.command} ${args.joinToString(" ")}"
	}

	fun execute(args: Array<String>): Boolean {
		println("Executing Gradle command: ${getCommand(args)} on path: ${configuration.path}")
		return commandExecutor.execute(getCommand(args), configuration.path)
	}
}
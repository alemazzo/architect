package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.utils.log.WithLogger
import io.micronaut.configuration.picocli.MicronautFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import picocli.CommandLine
import picocli.CommandLine.Command

@Factory
class CommandLineFactory(
	private val registry: PluginRegistry,
) : WithLogger {

	@Command
	class UsageCommand : Runnable {
		var commandLine: CommandLine? = null
		override fun run() {
			commandLine?.usage(System.out)
		}
	}

	@Singleton
	fun create(): CommandLine {
		logger.info("Creating architect line")
		val usage = UsageCommand()
		val commandLine = CommandLine(usage, MicronautFactory())
		usage.commandLine = commandLine
		registry.register(commandLine)
		logger.info("Command line created")
		return commandLine
	}

}
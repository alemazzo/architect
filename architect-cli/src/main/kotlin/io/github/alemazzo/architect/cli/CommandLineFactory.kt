package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.log.WithLogger
import io.github.alemazzo.architect.cli.context.MultiContextFactory
import io.github.alemazzo.architect.cli.plugins.plugins.PluginRegistry
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import picocli.CommandLine
import picocli.CommandLine.Command

@Factory
class CommandLineFactory(
	private val registry: PluginRegistry,
	private val multiContextFactory: MultiContextFactory,
) : WithLogger {

	@Command(
		name = "architect",
		description = ["Architect CLI"],
	)
	class UsageCommand : Runnable {
		private lateinit var commandLine: CommandLine

		fun injectCommandLine(commandLine: CommandLine) {
			this.commandLine = commandLine
		}

		override fun run() {
			commandLine.usage(System.out)
		}
	}

	@Singleton
	fun create(): CommandLine {
		logger.info("Creating command line")
		val usage = UsageCommand()
		val commandLine = CommandLine(usage, multiContextFactory)
		usage.injectCommandLine(commandLine)
		registry.register(commandLine)
		logger.info("Command line created")
		return commandLine
	}

}
package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.engine.api.context.MultiApplicationContextFactory
import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.github.alemazzo.architect.cli.engine.applications.components.EngineComponentRegistry
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import picocli.CommandLine
import picocli.CommandLine.Command

@Factory
class CommandLineFactory(
	private val registry: EngineComponentRegistry,
	private val multiContextFactory: MultiApplicationContextFactory,
) {

	private val logger = getLogger()

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
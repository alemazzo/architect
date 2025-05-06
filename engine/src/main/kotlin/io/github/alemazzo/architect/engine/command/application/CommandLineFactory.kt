package io.github.alemazzo.architect.engine.command.application

import io.github.alemazzo.architect.engine.context.api.MultiApplicationContextFactory
import io.github.alemazzo.architect.engine.utils.log.getLogger
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Model.UsageMessageSpec.SECTION_KEY_COMMAND_LIST
import picocli.CommandLine.Model.UsageMessageSpec.SECTION_KEY_COMMAND_LIST_HEADING

@Factory
class CommandLineFactory(
	private val registry: CommandRegistry,
	private val multiContextFactory: MultiApplicationContextFactory,
) {

	private val logger = getLogger()

	@Command(
		name = "architect",
		description = ["Architect CLI"],
	)
	class WrapperCommand : Runnable {
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
		logger.debug("Creating command line")
		val wrapperCommand = WrapperCommand()
		val commandLine = CommandLine(wrapperCommand, multiContextFactory)
		wrapperCommand.injectCommandLine(commandLine)
		commandLine.helpSectionMap[SECTION_KEY_COMMAND_LIST_HEADING] = CommandLine.IHelpSectionRenderer { "" }
		commandLine.helpSectionMap[SECTION_KEY_COMMAND_LIST] = GroupedCommandsRenderer
		registry.register(commandLine)
		logger.debug("Command line created")
		return commandLine
	}

}
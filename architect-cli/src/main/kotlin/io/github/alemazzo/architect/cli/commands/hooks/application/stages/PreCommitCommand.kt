package io.github.alemazzo.architect.cli.commands.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import io.github.alemazzo.architect.cli.commands.hooks.api.stages.PreCommitCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "pre-commit")
class PreCommitCommand(
	val context: CommitsContext,
	val preCommitCommands: List<PreCommitCommand>,
) : AbstractCommand {

	override fun run() {
		println("Executing pre-commit")
		preCommitCommands.forEach(PreCommitCommand::run)
		println("Pre-commit completed")
	}
}
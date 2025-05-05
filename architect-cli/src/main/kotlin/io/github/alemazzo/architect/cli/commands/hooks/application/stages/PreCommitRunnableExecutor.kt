package io.github.alemazzo.architect.cli.commands.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand
import io.github.alemazzo.architect.cli.commands.hooks.api.stages.PreCommit
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "pre-commit")
class PreCommitRunnableExecutor(
	val context: CommitsContext,
	val preCommits: List<io.github.alemazzo.architect.cli.commands.hooks.api.stages.PreCommit>,
) : AbstractCommand {

	override fun run() {
		println("Executing pre-commit")
		preCommits.forEach(io.github.alemazzo.architect.cli.commands.hooks.api.stages.PreCommit::run)
		println("Pre-commit completed")
	}
}
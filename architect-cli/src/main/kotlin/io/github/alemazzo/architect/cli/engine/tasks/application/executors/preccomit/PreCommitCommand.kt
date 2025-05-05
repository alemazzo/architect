package io.github.alemazzo.architect.cli.engine.tasks.application.executors.preccomit

import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import io.github.alemazzo.architect.cli.engine.tasks.api.precommit.PreCommitTask
import io.github.alemazzo.architect.cli.engine.tasks.application.TaskCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = PreCommitCommand.NAME)
class PreCommitCommand(
	val context: CommitsContext,
	val preCommitTasks: List<PreCommitTask>,
) : TaskCommand<PreCommitTask>(NAME, preCommitTasks) {

	companion object {
		const val NAME = "pre-commit"
	}

	override fun run() {
		println("Executing pre-commit")
		preCommitTasks.forEach(PreCommitTask::run)
		println("Pre-commit completed")
	}
}
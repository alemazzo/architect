package io.github.alemazzo.architect.engine.tasks.application.executors.commitmsg

import io.github.alemazzo.architect.engine.command.api.AbstractCommand
import io.github.alemazzo.architect.engine.tasks.api.commitmsg.CommitMsgTask
import io.github.alemazzo.architect.engine.tasks.application.TaskCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(name = CommitMsgCommand.NAME)
class CommitMsgCommand(
	private val commitMsgTasks: List<CommitMsgTask>
): TaskCommand<CommitMsgTask>(NAME, commitMsgTasks), AbstractCommand {

	companion object {
		const val NAME = "commit-msg"
	}

	@Parameters(
		description = ["The commit message to verify"],
	)
	var commitMessageFilePath: String = ""

	override fun run() {
		println("Executing commit-msg")
		commitMsgTasks.forEach { commitMsg ->
			commitMsg.commitMessageFilePath = commitMessageFilePath
			commitMsg.run()
		}
		println("Commit-msg completed")
	}
}
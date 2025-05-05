package io.github.alemazzo.architect.cli.commands.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import io.github.alemazzo.architect.cli.commands.hooks.api.stages.CommitMsgCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(name = "commit-msg")
class CommitMsgCommand(
	val context: CommitsContext,
	private val commitMsgCommands: List<CommitMsgCommand>
): AbstractCommand {

	@Parameters(
		description = ["The commit message to verify"],
	)
	var commitMessageFilePath: String = ""

	override fun run() {
		println("Executing commit-msg")
		commitMsgCommands.forEach { commitMsg ->
			commitMsg.commitMessageFilePath = commitMessageFilePath
			commitMsg.run()
		}
		println("Commit-msg completed")
	}
}
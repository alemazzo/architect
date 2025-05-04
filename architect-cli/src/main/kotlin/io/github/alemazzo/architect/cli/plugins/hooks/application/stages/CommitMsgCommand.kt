package io.github.alemazzo.architect.cli.plugins.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.PrePush
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.CommitMsg
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "commit-msg")
class CommitMsgCommand(
	val context: CommitsContext,
	private val commitMsgs: List<CommitMsg>
) : Verify {
	override fun run() {
		println("Executing commit-msg")
		commitMsgs.forEach(CommitMsg::run)
		println("Commit-msg completed")
	}
}
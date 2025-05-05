package io.github.alemazzo.architect.cli.commands.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import io.github.alemazzo.architect.cli.commands.hooks.api.stages.PrePushCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(name = "pre-push")
class PrePushCommand(
	val context: CommitsContext,
	val preCommits: List<PrePushCommand>
) : AbstractCommand {

	@Parameters
	var remote: String = ""

	@Parameters
	var refspec: String = ""


	override fun run() {
		println("Executing pre-push")
		preCommits.forEach { prePush ->
			prePush.remote = remote
			prePush.refspec = refspec
			prePush.run()
		}
		println("Pre-push completed")
	}
}
package io.github.alemazzo.architect.engine.tasks.application.executors.prepush

import io.github.alemazzo.architect.engine.tasks.api.prepush.PrePushTask
import io.github.alemazzo.architect.engine.tasks.application.TaskCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(name = PrePushCommand.NAME)
class PrePushCommand(
	val preCommits: List<PrePushTask>
) : TaskCommand<PrePushTask>(NAME, preCommits) {

	companion object {
		const val NAME = "pre-push"
	}

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
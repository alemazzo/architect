package io.github.alemazzo.architect.cli.plugins.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.api.ArchitectCommand
import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent
import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.PrePush
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(name = "pre-push")
class PrePushCommandExecutor(
	val context: CommitsContext,
	val preCommits: List<PrePush>
) : EngineComponent {

	override val name: String = "pre-push"

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
package io.github.alemazzo.architect.cli.plugins.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.PrePush
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "pre-push")
class PrePushCommand(
	val context: CommitsContext,
	val preCommits: List<PrePush>
) : Verify {
	override fun run() {
		println("Executing pre-push")
		preCommits.forEach(PrePush::run)
		println("Pre-push completed")
	}
}
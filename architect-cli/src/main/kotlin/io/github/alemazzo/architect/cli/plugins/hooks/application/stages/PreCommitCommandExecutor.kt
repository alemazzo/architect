package io.github.alemazzo.architect.cli.plugins.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.api.ArchitectCommand
import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent
import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.PreCommit
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "pre-commit")
class PreCommitCommandExecutor(
	val context: CommitsContext,
	val preCommits: List<PreCommit>,
) : EngineComponent {

	override val name: String = "pre-commit"

	override fun run() {
		println("Executing pre-commit")
		preCommits.forEach(PreCommit::run)
		println("Pre-commit completed")
	}
}
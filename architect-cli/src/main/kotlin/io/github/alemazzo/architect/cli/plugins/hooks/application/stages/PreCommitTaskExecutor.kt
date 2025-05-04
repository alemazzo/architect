package io.github.alemazzo.architect.cli.plugins.hooks.application.stages

import io.github.alemazzo.architect.cli.engine.api.ArchitectTask
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.PreCommit
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "pre-commit")
class PreCommitTaskExecutor(
	val context: CommitsContext,
	val preCommits: List<PreCommit>,
) : ArchitectTask {

	override fun run() {
		println("Executing pre-commit")
		preCommits.forEach(PreCommit::run)
		println("Pre-commit completed")
	}
}
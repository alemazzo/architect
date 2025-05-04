package io.github.alemazzo.architect.cli.plugins.commits

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.commits.application.InitCommitsTask
import io.github.alemazzo.architect.cli.plugins.commits.application.VerifyCommitMessageTask
import io.github.alemazzo.architect.cli.plugins.commits.application.VerifyCommitsTask
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = CommitsTask.name,
	description = ["Run the commits commands"],
	subcommands = [
		InitCommitsTask::class,
		VerifyCommitsTask::class,
		VerifyCommitMessageTask::class,
  	],
)
class CommitsTask : Plugin<CommitsContext>(name) {

	companion object {
		const val name = "commits"
	}
}


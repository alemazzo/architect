package io.github.alemazzo.architect.cli.plugins.commits

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.commits.application.InitTaskCommitsTask
import io.github.alemazzo.architect.cli.plugins.commits.application.VerifyCommitMessageRunnable
import io.github.alemazzo.architect.cli.plugins.commits.application.VerifyTasksCommitsRunnable
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = CommitsRunnable.name,
	description = ["Run the commits command"],
	subcommands = [
		InitTaskCommitsTask::class,
		VerifyTasksCommitsRunnable::class,
		VerifyCommitMessageRunnable::class,
  	],
)
class CommitsRunnable : PluginCommand<CommitsContext>(name) {

	companion object {
		const val name = "commits"
	}
}


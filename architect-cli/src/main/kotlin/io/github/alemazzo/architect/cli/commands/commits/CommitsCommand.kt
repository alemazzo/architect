package io.github.alemazzo.architect.cli.commands.commits

import io.github.alemazzo.architect.cli.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.commits.application.VerifyCommitMessageTask
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = CommitsCommand.name,
	description = ["Run the commits command"],
	subcommands = [
		VerifyCommitMessageTask::class,
  	],
)
class CommitsCommand : PluginCommand<CommitsContext>(name) {

	companion object {
		const val name = "commits"
	}
}


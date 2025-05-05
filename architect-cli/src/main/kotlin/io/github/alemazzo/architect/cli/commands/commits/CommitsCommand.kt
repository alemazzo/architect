package io.github.alemazzo.architect.cli.commands.commits

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.commits.application.CommitsInitTask
import io.github.alemazzo.architect.cli.commands.commits.application.VerifyCommitMessageCommand
import io.github.alemazzo.architect.cli.commands.commits.application.CommitsVerifyTask
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = CommitsCommand.name,
	description = ["Run the commits command"],
	subcommands = [
		CommitsInitTask::class,
		CommitsVerifyTask::class,
		VerifyCommitMessageCommand::class,
  	],
)
class CommitsCommand : PluginCommand<CommitsContext>(name) {

	companion object {
		const val name = "commits"
	}
}


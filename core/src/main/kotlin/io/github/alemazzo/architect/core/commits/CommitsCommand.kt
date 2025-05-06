package io.github.alemazzo.architect.core.commits

import io.github.alemazzo.architect.core.commits.CommitsCommand.Companion.name
import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.core.commits.application.VerifyCommitMessageTask
import io.github.alemazzo.architect.core.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = name,
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


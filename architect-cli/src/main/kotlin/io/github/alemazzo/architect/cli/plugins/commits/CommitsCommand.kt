package io.github.alemazzo.architect.cli.plugins.commits

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.commits.application.InitCommitsCommand
import io.github.alemazzo.architect.cli.plugins.commits.application.VerifyCommitsCommand
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = CommitsCommand.name,
	description = ["Run the commits commands"],
	subcommands = [
		InitCommitsCommand::class,
		VerifyCommitsCommand::class
  	],
)
class CommitsCommand : Plugin<CommitsContext>(name) {

	companion object {
		const val name = "commits"
	}
}


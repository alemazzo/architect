package io.github.alemazzo.architect.cli.plugins.conventional.commits.actions

import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.plugins.conventional.commits.context.ConventionalCommitsContext
import io.github.alemazzo.architect.cli.utils.execution.CommandExecutor
import jakarta.inject.Singleton

@Singleton
class InstallConventionalCommits(val context: ConventionalCommitsContext, val commandExecutor: CommandExecutor) :
	Initializer {

	override fun run() {
		commandExecutor.execute(context.command, context.path)
	}
}
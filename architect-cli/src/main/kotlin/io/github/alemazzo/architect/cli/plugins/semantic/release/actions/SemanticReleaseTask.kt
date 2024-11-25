package io.github.alemazzo.architect.cli.plugins.semantic.release.actions

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.command.release.Releaser
import io.github.alemazzo.architect.cli.plugins.semantic.release.api.SemanticReleaseConfiguration
import io.github.alemazzo.architect.cli.utils.CommandExecutor

@Architect
class SemanticReleaseTask(
	private val configuration: SemanticReleaseConfiguration,
	private val commandExecutor: CommandExecutor,
) : Releaser {
	override fun run() {
		println("Releasing project with Semantic Release")
		// Move the jar from the build folder into the release folder
		// and then run the semantic release command
		val releaseCommand = "cp ./architect-cli/build/libs/architect-cli-0.1-all.jar ${configuration.path}/"
		commandExecutor.execute(releaseCommand, false)
		commandExecutor.execute(configuration.command, false, configuration.path)
	}
}

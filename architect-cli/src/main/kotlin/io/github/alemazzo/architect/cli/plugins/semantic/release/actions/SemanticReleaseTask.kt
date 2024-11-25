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
		configuration.assets.forEach { asset ->
			val copyCommand = "cp ${asset.path} ${configuration.path}/${asset.name}"
			commandExecutor.execute(copyCommand)
		}
		commandExecutor.execute(configuration.command, configuration.path)
	}
}

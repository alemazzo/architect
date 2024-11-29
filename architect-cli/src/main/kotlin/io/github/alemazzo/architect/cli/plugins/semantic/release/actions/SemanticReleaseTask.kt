package io.github.alemazzo.architect.cli.plugins.semantic.release.actions

import io.github.alemazzo.architect.cli.api.architect.release.Releaser
import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import io.github.alemazzo.architect.cli.utils.execution.CommandExecutor
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "release")
class SemanticReleaseTask(
	private val context: SemanticReleaseContext,
	private val commandExecutor: CommandExecutor,
) : Releaser {
	override fun run() {
		logger.info("Releasing project with Semantic Release")
		context.assets.forEach { asset ->
			val copyCommand = "cp ${asset.path} ${context.path}/${asset.name}"
			commandExecutor.execute(copyCommand)
		}
		commandExecutor.execute(context.command, context.path)
	}
}

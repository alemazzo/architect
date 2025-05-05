package io.github.alemazzo.architect.cli.commands.pipelines

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.pipelines.application.PipelinesInitTask
import io.github.alemazzo.architect.cli.commands.pipelines.application.PipelinesVerifyTask
import io.github.alemazzo.architect.cli.commands.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = PipelinesCommand.name,
	description = ["Run the pipelines command"],
	subcommands = [
		PipelinesInitTask::class,
		PipelinesVerifyTask::class,
	]
)

class PipelinesCommand : PluginCommand<PipelinesContextHolder>(name) {
	companion object {
		const val name = "pipelines"
	}
}
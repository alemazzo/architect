package io.github.alemazzo.architect.core.pipelines

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.core.pipelines.application.PipelinesInitTask
import io.github.alemazzo.architect.core.pipelines.application.PipelinesVerifyTask
import io.github.alemazzo.architect.core.pipelines.context.PipelinesContextHolder
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
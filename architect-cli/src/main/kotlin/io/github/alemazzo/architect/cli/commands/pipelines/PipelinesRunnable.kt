package io.github.alemazzo.architect.cli.commands.pipelines

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesInitTaskTask
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesVerifyTasksRunnable
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = PipelinesRunnable.name,
	description = ["Run the pipelines command"],
	subcommands = [
		PipelinesInitTaskTask::class,
		PipelinesVerifyTasksRunnable::class,
	]
)

class PipelinesRunnable : PluginCommand<PipelinesContextHolder>(name) {
	companion object {
		const val name = "pipelines"
	}
}
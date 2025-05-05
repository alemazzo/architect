package io.github.alemazzo.architect.cli.plugins.deps

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.deps.application.DepsInitTaskTask
import io.github.alemazzo.architect.cli.plugins.deps.application.DepsVerifyTasksRunnable
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = DepsRunnable.name,
	description = ["Run the deps command"],
	subcommands = [
		DepsInitTaskTask::class,
		DepsVerifyTasksRunnable::class,
	]
)

class DepsRunnable : PluginCommand<PipelinesContextHolder>(name) {
	companion object {
		const val name = "deps"
	}
}
package io.github.alemazzo.architect.cli.plugins.scripts

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsInitTaskTask
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsVerifyTasksRunnable
import io.github.alemazzo.architect.cli.plugins.scripts.context.ScriptsContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ScriptsRunnable.NAME,
	description = ["Run the scripts command"],
	subcommands = [
		ScriptsInitTaskTask::class,
		ScriptsVerifyTasksRunnable::class,
	]
)
class ScriptsRunnable() : PluginCommand<ScriptsContext>(NAME) {
	companion object {
		const val NAME = "scripts"
	}
}
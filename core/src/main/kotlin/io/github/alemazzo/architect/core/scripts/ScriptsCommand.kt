package io.github.alemazzo.architect.core.scripts

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.core.scripts.application.ScriptsInitTask
import io.github.alemazzo.architect.core.scripts.application.ScriptsVerifyTask
import io.github.alemazzo.architect.core.scripts.context.ScriptsContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ScriptsCommand.NAME,
	description = ["Run the scripts command"],
	subcommands = [
		ScriptsInitTask::class,
		ScriptsVerifyTask::class,
	]
)
class ScriptsCommand : PluginCommand<ScriptsContext>(NAME) {
	companion object {
		const val NAME = "scripts"
	}
}
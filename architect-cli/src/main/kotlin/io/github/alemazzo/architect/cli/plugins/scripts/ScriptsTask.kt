package io.github.alemazzo.architect.cli.plugins.scripts

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsInitTask
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsVerifyTask
import io.github.alemazzo.architect.cli.plugins.scripts.context.ScriptsContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ScriptsTask.NAME,
	description = ["Run the scripts commands"],
	subcommands = [
		ScriptsInitTask::class,
		ScriptsVerifyTask::class,
	]
)
class ScriptsTask() : Plugin<ScriptsContext>(NAME) {
	companion object {
		const val NAME = "scripts"
	}
}
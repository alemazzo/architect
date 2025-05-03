package io.github.alemazzo.architect.cli.plugins.scripts

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsInitCommand
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsVerifyCommand
import io.github.alemazzo.architect.cli.plugins.scripts.context.ScriptsContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ScriptsCommand.NAME,
	description = ["Run the scripts commands"],
	subcommands = [
		ScriptsInitCommand::class,
		ScriptsVerifyCommand::class,
	]
)
class ScriptsCommand(
	@JsonProperty(NAME)
	override val context: ScriptsContext? = null,
) : Plugin<ScriptsContext>(NAME) {
	companion object {
		const val NAME = "scripts"
	}
}
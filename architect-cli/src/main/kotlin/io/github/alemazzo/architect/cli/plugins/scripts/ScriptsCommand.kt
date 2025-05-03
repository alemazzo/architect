package io.github.alemazzo.architect.cli.plugins.scripts

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.scripts.actions.ScriptsInitCommand
import io.github.alemazzo.architect.cli.plugins.scripts.actions.ScriptsVerifyCommand
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
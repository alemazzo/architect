package io.github.alemazzo.architect.cli.plugins.hooks

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.hooks.context.HooksContext
import io.github.alemazzo.architect.cli.plugins.scripts.actions.ScriptsInitCommand
import io.github.alemazzo.architect.cli.plugins.scripts.actions.ScriptsVerifyCommand
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = HooksCommand.name,
	description = ["Run the hooks commands"],
	subcommands = [
		ScriptsInitCommand::class,
		ScriptsVerifyCommand::class,
	]
)

class HooksCommand(
	@JsonProperty(name)
	override val context: HooksContext?,
) : Plugin<HooksContext>(name) {
	companion object {
		const val name = "hooks"
	}
}
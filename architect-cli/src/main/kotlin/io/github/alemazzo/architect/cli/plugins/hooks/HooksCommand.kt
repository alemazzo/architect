package io.github.alemazzo.architect.cli.plugins.hooks

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksInitCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksVerifyCommand
import io.github.alemazzo.architect.cli.plugins.hooks.context.HooksContext
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsInitCommand
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsVerifyCommand
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = HooksCommand.name,
	description = ["Run the hooks commands"],
	subcommands = [
		HooksInitCommand::class,
		HooksVerifyCommand::class,
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
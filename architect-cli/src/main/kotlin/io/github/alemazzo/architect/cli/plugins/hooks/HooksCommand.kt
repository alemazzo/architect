package io.github.alemazzo.architect.cli.plugins.hooks

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksInitCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksVerifyCommand
import io.github.alemazzo.architect.cli.plugins.hooks.context.HooksContext
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

class HooksCommand : Plugin<HooksContext>(name) {
	companion object {
		const val name = "hooks"
	}
}
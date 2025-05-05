package io.github.alemazzo.architect.cli.commands.hooks

import io.github.alemazzo.architect.cli.commands.hooks.HooksCommand.Companion.name
import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.hooks.application.HooksVerifyTask
import io.github.alemazzo.architect.cli.commands.hooks.application.stages.CommitMsgCommand
import io.github.alemazzo.architect.cli.commands.hooks.application.stages.PreCommitCommand
import io.github.alemazzo.architect.cli.commands.hooks.application.stages.PrePushCommand
import io.github.alemazzo.architect.cli.commands.hooks.context.HooksContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = name,
	description = ["Run the hooks command"],
	subcommands = [
		io.github.alemazzo.architect.cli.commands.hooks.application.HooksInitTask::class,
		HooksVerifyTask::class,
		PreCommitCommand::class,
		PrePushCommand::class,
		CommitMsgCommand::class
	]
)

class HooksCommand : PluginCommand<HooksContext>(name) {
	companion object {
		const val name = "hooks"
	}
}
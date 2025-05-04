package io.github.alemazzo.architect.cli.plugins.hooks

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksInitCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksVerifyCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.CommitMsgCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PreCommitCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PrePushCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesInitCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesVerifyCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = HooksCommand.name,
	description = ["Run the hooks commands"],
	subcommands = [
		HooksInitCommand::class,
		HooksVerifyCommand::class,
		PreCommitCommand::class,
		PrePushCommand::class,
		CommitMsgCommand::class
	]
)

class HooksCommand : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "hooks"
	}
}
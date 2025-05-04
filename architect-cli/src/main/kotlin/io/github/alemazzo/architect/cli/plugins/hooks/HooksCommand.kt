package io.github.alemazzo.architect.cli.plugins.hooks

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksInitCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksVerifyCommand
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.CommitMsgCommandExecutor
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PreCommitCommandExecutor
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PrePushCommandExecutor
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
		PreCommitCommandExecutor::class,
		PrePushCommandExecutor::class,
		CommitMsgCommandExecutor::class
	]
)

class HooksCommand : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "hooks"
	}
}
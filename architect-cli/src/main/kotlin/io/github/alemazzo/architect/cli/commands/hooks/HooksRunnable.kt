package io.github.alemazzo.architect.cli.commands.hooks

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.hooks.application.HooksInitTaskTask
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksVerifyTasksRunnable
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.CommitMsgRunnableExecutor
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PreCommitRunnableExecutor
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PrePushRunnableExecutor
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = io.github.alemazzo.architect.cli.commands.hooks.HooksRunnable.Companion.name,
	description = ["Run the hooks command"],
	subcommands = [
		io.github.alemazzo.architect.cli.commands.hooks.application.HooksInitTaskTask::class,
		HooksVerifyTasksRunnable::class,
		PreCommitRunnableExecutor::class,
		PrePushRunnableExecutor::class,
		CommitMsgRunnableExecutor::class
	]
)

class HooksRunnable : PluginCommand<PipelinesContextHolder>(io.github.alemazzo.architect.cli.commands.hooks.HooksRunnable.Companion.name) {
	companion object {
		const val name = "hooks"
	}
}
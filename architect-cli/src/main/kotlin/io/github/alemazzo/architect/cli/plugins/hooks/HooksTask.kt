package io.github.alemazzo.architect.cli.plugins.hooks

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksInitTask
import io.github.alemazzo.architect.cli.plugins.hooks.application.HooksVerifyTask
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.CommitMsgTaskExecutor
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PreCommitTaskExecutor
import io.github.alemazzo.architect.cli.plugins.hooks.application.stages.PrePushTaskExecutor
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = HooksTask.name,
	description = ["Run the hooks commands"],
	subcommands = [
		HooksInitTask::class,
		HooksVerifyTask::class,
		PreCommitTaskExecutor::class,
		PrePushTaskExecutor::class,
		CommitMsgTaskExecutor::class
	]
)

class HooksTask : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "hooks"
	}
}
package io.github.alemazzo.architect.cli.plugins.pipelines

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesInitTask
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesVerifyTask
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = PipelinesTask.name,
	description = ["Run the pipelines commands"],
	subcommands = [
		PipelinesInitTask::class,
		PipelinesVerifyTask::class,
	]
)

class PipelinesTask : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "pipelines"
	}
}
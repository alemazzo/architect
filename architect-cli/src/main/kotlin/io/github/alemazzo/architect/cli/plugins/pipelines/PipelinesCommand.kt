package io.github.alemazzo.architect.cli.plugins.pipelines

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesInitCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.application.PipelinesVerifyCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = PipelinesCommand.name,
	description = ["Run the pipelines commands"],
	subcommands = [
		PipelinesInitCommand::class,
		PipelinesVerifyCommand::class,
	]
)

class PipelinesCommand : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "pipelines"
	}
}
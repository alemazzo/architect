package io.github.alemazzo.architect.cli.plugins.deps

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.deps.application.DepsInitCommand
import io.github.alemazzo.architect.cli.plugins.deps.application.DepsVerifyCommand
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = DepsCommand.name,
	description = ["Run the deps commands"],
	subcommands = [
		DepsInitCommand::class,
		DepsVerifyCommand::class,
	]
)

class DepsCommand : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "deps"
	}
}
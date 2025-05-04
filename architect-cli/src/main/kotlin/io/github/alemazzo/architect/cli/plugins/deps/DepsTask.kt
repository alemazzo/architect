package io.github.alemazzo.architect.cli.plugins.deps

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.deps.application.DepsInitTask
import io.github.alemazzo.architect.cli.plugins.deps.application.DepsVerifyTask
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = DepsTask.name,
	description = ["Run the deps commands"],
	subcommands = [
		DepsInitTask::class,
		DepsVerifyTask::class,
	]
)

class DepsTask : Plugin<PipelinesContextHolder>(name) {
	companion object {
		const val name = "deps"
	}
}
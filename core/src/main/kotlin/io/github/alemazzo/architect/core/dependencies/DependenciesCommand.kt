package io.github.alemazzo.architect.core.dependencies

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.core.dependencies.application.DependenciesInitTask
import io.github.alemazzo.architect.core.dependencies.application.DependenciesVerifyTask
import io.github.alemazzo.architect.core.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = DependenciesCommand.name,
	description = ["Run the dependencies command"],
	subcommands = [
		DependenciesInitTask::class,
		DependenciesVerifyTask::class,
	]
)

class DependenciesCommand : PluginCommand<PipelinesContextHolder>(name) {
	companion object {
		const val name = "deps"
	}
}
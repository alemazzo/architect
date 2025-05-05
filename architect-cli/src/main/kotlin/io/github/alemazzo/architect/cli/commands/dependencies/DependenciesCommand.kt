package io.github.alemazzo.architect.cli.commands.dependencies

import io.github.alemazzo.architect.cli.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.dependencies.application.DependenciesInitTask
import io.github.alemazzo.architect.cli.commands.dependencies.application.DependenciesVerifyTask
import io.github.alemazzo.architect.cli.commands.pipelines.context.PipelinesContextHolder
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
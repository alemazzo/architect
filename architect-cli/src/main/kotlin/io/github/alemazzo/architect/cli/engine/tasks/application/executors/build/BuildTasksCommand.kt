package io.github.alemazzo.architect.cli.engine.tasks.application.executors.build

import io.github.alemazzo.architect.cli.engine.tasks.api.build.BuildTask
import io.github.alemazzo.architect.cli.engine.tasks.application.TaskCommand
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = BuildTasksCommand.NAME,
	description = ["Build the application"],
	mixinStandardHelpOptions = true,
)
@Order(3)
class BuildTasksCommand(buildTasks: List<BuildTask>) : TaskCommand<BuildTask>(NAME, buildTasks) {

	companion object {
		const val NAME = "build"
	}

}


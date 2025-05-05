package io.github.alemazzo.architect.cli.engine.components.tasks.application.executors.load

import io.github.alemazzo.architect.cli.engine.components.tasks.api.load.LoadTask
import io.github.alemazzo.architect.cli.engine.components.tasks.application.TaskCommand
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = LoadTasksCommand.NAME,
	description = ["Load the application"],
	mixinStandardHelpOptions = true,
)
@Order(6)
class LoadTasksCommand(loadTasks: List<LoadTask>) : TaskCommand<LoadTask>(NAME, loadTasks) {

	companion object {
		const val NAME = "release"
	}

}
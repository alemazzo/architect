package io.github.alemazzo.architect.cli.engine.components.tasks.application.executors.release

import io.github.alemazzo.architect.cli.engine.components.tasks.api.release.ReleaseTask
import io.github.alemazzo.architect.cli.engine.components.tasks.application.TaskCommand
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = ReleaseTasksCommand.NAME,
	description = ["Release the application"],
	mixinStandardHelpOptions = true,
)
@Order(6)
class ReleaseTasksCommand(releaseTasks: List<ReleaseTask>) : TaskCommand<ReleaseTask>(NAME, releaseTasks) {

	companion object {
		const val NAME = "release"
	}

}
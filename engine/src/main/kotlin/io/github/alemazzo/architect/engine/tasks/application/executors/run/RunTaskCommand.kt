package io.github.alemazzo.architect.engine.tasks.application.executors.run

import io.github.alemazzo.architect.engine.tasks.api.run.RunTask
import io.github.alemazzo.architect.engine.tasks.application.TaskCommand
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = RunTaskCommand.NAME,
	description = ["Run the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(4)
class RunTaskCommand(runners: List<RunTask>) : TaskCommand<RunTask>(NAME, runners) {

	companion object {
		const val NAME = "run"
	}

}


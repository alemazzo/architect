package io.github.alemazzo.architect.cli.engine.tasks.application.executors.test

import io.github.alemazzo.architect.cli.engine.tasks.api.test.TestTask
import io.github.alemazzo.architect.cli.engine.tasks.application.TaskCommand
import io.github.alemazzo.architect.cli.engine.tasks.application.executors.test.TestTaskCommand.Companion.NAME
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = NAME,
	description = ["Test the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(5)
class TestTaskCommand(testTasks: List<TestTask>) : TaskCommand<TestTask>(NAME, testTasks) {

	companion object {
		const val NAME = "test"
	}

}


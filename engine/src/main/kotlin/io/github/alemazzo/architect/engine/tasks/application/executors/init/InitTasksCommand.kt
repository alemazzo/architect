package io.github.alemazzo.architect.engine.tasks.application.executors.init

import io.github.alemazzo.architect.engine.tasks.api.init.InitTask
import io.github.alemazzo.architect.engine.tasks.application.TaskCommand
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = InitTasksCommand.NAME,
	description = ["Initialize the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class InitTasksCommand(initTasks: List<InitTask>) : TaskCommand<InitTask>(NAME, initTasks) {

	companion object {
		const val NAME = "init"
	}

}

package io.github.alemazzo.architect.engine.tasks

import io.github.alemazzo.architect.engine.command.api.Command
import io.github.alemazzo.architect.engine.tasks.application.executors.build.BuildTasksCommand
import io.github.alemazzo.architect.engine.tasks.application.executors.init.InitTasksCommand
import io.github.alemazzo.architect.engine.tasks.application.executors.release.ReleaseTasksCommand
import io.github.alemazzo.architect.engine.tasks.application.executors.run.RunTaskCommand
import io.github.alemazzo.architect.engine.tasks.application.executors.test.TestTaskCommand
import io.github.alemazzo.architect.engine.tasks.application.executors.verify.VerifyTaskCommand
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = TasksCommand.NAME,
	description = ["Execute the phase command"],
	mixinStandardHelpOptions = true,
	subcommands = [
		InitTasksCommand::class,
		VerifyTaskCommand::class,
		BuildTasksCommand::class,
		RunTaskCommand::class,
		TestTaskCommand::class,
		ReleaseTasksCommand::class,
	]
)
class TasksCommand(
) : Command(NAME) {

	companion object {
		const val NAME = "tasks"
	}
}
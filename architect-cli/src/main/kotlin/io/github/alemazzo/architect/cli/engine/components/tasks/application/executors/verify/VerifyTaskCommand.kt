package io.github.alemazzo.architect.cli.engine.components.tasks.application.executors.verify

import io.github.alemazzo.architect.cli.engine.components.tasks.api.verify.VerifyTasks
import io.github.alemazzo.architect.cli.engine.components.tasks.application.TaskCommand
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = VerifyTaskCommand.NAME,
	description = ["Verify the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(2)
class VerifyTaskCommand(verifiers: List<VerifyTasks>) : TaskCommand<VerifyTasks>(NAME, verifiers) {

	companion object {
		const val NAME = "verify"
	}

}


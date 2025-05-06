package io.github.alemazzo.architect.engine.tasks.application.executors.verify

import io.github.alemazzo.architect.engine.tasks.api.verify.VerifyTask
import io.github.alemazzo.architect.engine.tasks.application.TaskCommand
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
class VerifyTaskCommand(verifiers: List<VerifyTask>) : TaskCommand<VerifyTask>(NAME, verifiers) {

	companion object {
		const val NAME = "verify"
	}

}


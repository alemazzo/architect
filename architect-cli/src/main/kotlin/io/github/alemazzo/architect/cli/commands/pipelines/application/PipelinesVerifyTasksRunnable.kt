package io.github.alemazzo.architect.cli.commands.pipelines.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.verify.VerifyTasks
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class PipelinesVerifyTasksRunnable : VerifyTasks {

	override fun run() {
		println("Verifying pipelines...")
	}

}
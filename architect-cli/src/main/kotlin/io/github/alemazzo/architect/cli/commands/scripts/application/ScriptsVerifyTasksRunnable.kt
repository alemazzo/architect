package io.github.alemazzo.architect.cli.commands.scripts.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.verify.VerifyTasks
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class ScriptsVerifyTasksRunnable : VerifyTasks {

	override fun run() {
		println("Executing scripts verify")
	}

}
package io.github.alemazzo.architect.cli.plugins.deps.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.verify.VerifyTasks
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class DepsVerifyTasksRunnable : VerifyTasks {

	override fun run() {
		println("Verifying deps...")
	}

}
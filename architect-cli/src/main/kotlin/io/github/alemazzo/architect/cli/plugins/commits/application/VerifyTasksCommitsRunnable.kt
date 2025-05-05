package io.github.alemazzo.architect.cli.plugins.commits.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.verify.VerifyTasks
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class VerifyTasksCommitsRunnable(
	val context: CommitsContext,
) : VerifyTasks {
	override fun run() {
		println("Executing commits verify")
	}
}
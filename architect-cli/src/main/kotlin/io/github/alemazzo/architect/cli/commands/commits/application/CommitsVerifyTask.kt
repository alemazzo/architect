package io.github.alemazzo.architect.cli.commands.commits.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.verify.VerifyTask
import io.github.alemazzo.architect.cli.commands.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class CommitsVerifyTask(
	val context: CommitsContext,
) : VerifyTask {
	override fun run() {
		println("Executing commits verify")
	}
}
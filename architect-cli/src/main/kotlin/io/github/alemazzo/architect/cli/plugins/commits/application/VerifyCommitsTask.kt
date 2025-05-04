package io.github.alemazzo.architect.cli.plugins.commits.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class VerifyCommitsTask(
	val context: CommitsContext,
) : Verify {
	override fun run() {
		println("Executing commits verify")
	}
}
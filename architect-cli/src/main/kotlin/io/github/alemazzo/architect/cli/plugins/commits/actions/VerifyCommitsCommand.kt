package io.github.alemazzo.architect.cli.plugins.commits.actions

import io.github.alemazzo.architect.cli.api.phases.verify.Verify
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class VerifyCommitsCommand(
	val context: CommitsContext,
) : Verify {
	override fun run() {
		println("Executing commits verify")
	}
}
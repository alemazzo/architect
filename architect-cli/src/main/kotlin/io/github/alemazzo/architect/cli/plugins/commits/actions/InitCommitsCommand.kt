package io.github.alemazzo.architect.cli.plugins.commits.actions

import io.github.alemazzo.architect.cli.api.phases.init.Init
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class InitCommitsCommand(
	val context: CommitsContext,
) : Init {
	override fun run() {
		println("Executing commits init")
	}
}
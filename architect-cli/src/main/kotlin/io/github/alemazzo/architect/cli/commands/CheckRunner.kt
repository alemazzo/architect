package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.utils.GroupRunner
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "check",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class CheckRunner(checks: List<Check>) : GroupRunner(checks), ArchitectCommand {

	override fun run() {
		super.run()
		println("All checks passed")
	}

}



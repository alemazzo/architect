package io.github.alemazzo.architect.cli.commands.tasks

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
class ChecksRunner(checks: List<Check>) : GroupRunner(checks), ArchitectCommand {

	override fun run() {
		super.run()
		println("All checks passed")
	}

}



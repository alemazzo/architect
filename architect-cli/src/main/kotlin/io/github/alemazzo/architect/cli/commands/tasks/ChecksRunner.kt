package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.configuration.RequireContext
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Command(
	name = "check",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
@RequireContext
class ChecksRunner : ArchitectCommand {

	@Inject
	lateinit var checks: List<Check>

	override fun run() {
		checks.forEach { it.run() }
		println("All checks passed")
	}

}



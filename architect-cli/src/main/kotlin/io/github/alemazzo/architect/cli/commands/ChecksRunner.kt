package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.check.Check
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Command(
	name = "check",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class ChecksRunner : ArchitectCommand {

	@Inject
	lateinit var checks: List<Check>

	override fun run() {
		checks.forEach { it.run() }
		logger.info("All checks passed")
	}

}



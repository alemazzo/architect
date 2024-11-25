package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.check.Check
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "check",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class CheckCommand(val checks: List<Check>) : Runnable {
	override fun run() {
		checks.forEach(Check::run)
		println("All checks passed")
	}
}


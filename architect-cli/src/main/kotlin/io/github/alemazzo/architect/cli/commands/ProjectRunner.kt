package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Singleton
@Command(
	name = "project",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class ProjectRunner : ArchitectCommand {

	@Option(names = ["-n", "--name"], description = ["The name of the project"])
	var name: String? = null

	override fun run() {
		println("Hello from Project! $name")
	}
}
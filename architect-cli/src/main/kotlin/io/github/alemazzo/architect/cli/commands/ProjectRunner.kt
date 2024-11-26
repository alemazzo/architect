package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.context.RequireContext
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(
	name = "project",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
@RequireContext
class ProjectRunner : ArchitectCommand {

	@Option(names = ["-n", "--name"], description = ["The name of the project"])
	var name: String? = null

	override fun run() {
		println("Hello from Project! $name")
	}
}
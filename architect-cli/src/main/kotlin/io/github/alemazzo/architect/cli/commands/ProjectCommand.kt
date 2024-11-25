package io.github.alemazzo.architect.cli.commands

import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Singleton
@Command(
	name = "project",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class ProjectCommand : Runnable {

	@Option(names = ["-n", "--name"], description = ["The name of the project"])
	var name: String? = null

	override fun run() {
		println("Hello from Project! $name")
	}
}
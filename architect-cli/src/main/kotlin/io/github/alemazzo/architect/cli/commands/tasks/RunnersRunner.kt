package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.run.Runner
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(
	name = "run",
	description = ["Run the application"]
)
class RunnersRunner(private val runners: List<Runner>) : ArchitectCommand {

	@Parameters(
		description = ["The name of the runner to execute"],
		defaultValue = ""
	)
	private var runnerName: String = ""

	override fun run() {
		if (runnerName.isNotEmpty()) {
			val runner = runners.find { it.name == runnerName }
			if (runner != null) {
				runner.run()
				println("Runner $runnerName executed")
			} else {
				println("Runner $runnerName not found")
			}
		}
	}

}
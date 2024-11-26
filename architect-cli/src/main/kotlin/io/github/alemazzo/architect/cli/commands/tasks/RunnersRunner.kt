package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.run.Runner
import io.github.alemazzo.architect.cli.context.RequireContext
import jakarta.inject.Inject
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Command(
	name = "run",
	description = ["Run the application"]
)
@RequireContext
class RunnersRunner : ArchitectCommand {

	@Inject
	lateinit var runners: List<Runner>

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

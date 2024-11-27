package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.run.Runner
import jakarta.inject.Inject
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Command(
	name = "run",
	description = ["Run the application"]
)
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
				logger.info("Runner $runnerName passed")
			} else {
				logger.error("Runner $runnerName not found")
			}
		}
	}

}

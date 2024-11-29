package io.github.alemazzo.architect.cli.plugins.architect.plugins.run

import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.api.architect.run.Runner
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(
	name = "run",
	description = ["Run a specific runner"],
)
@Order(3)
class RunnerPlugin(private val runners: List<Runner>) : Plugin<Void>(name) {
	override val context: Void? = null

	companion object {
		const val name = "run"
	}

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

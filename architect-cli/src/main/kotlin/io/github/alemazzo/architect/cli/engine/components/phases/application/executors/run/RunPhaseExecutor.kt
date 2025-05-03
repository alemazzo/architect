package io.github.alemazzo.architect.cli.engine.components.phases.application.executors.run

import io.github.alemazzo.architect.cli.engine.components.phases.api.run.Run
import io.github.alemazzo.architect.cli.engine.components.phases.application.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = RunPhaseExecutor.NAME,
	description = ["Run the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class RunPhaseExecutor(runners: List<Run>) : PhaseExecutor<Run>(NAME, runners) {

	companion object {
		const val NAME = "run"
	}

}


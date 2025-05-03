package io.github.alemazzo.architect.cli.engine.phases.verify

import io.github.alemazzo.architect.cli.api.phases.run.Run
import io.github.alemazzo.architect.cli.engine.phases.PhaseExecutor
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


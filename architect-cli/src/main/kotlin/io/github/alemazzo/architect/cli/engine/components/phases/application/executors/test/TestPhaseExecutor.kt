package io.github.alemazzo.architect.cli.engine.components.phases.application.executors.test

import io.github.alemazzo.architect.cli.engine.components.phases.api.test.Test
import io.github.alemazzo.architect.cli.engine.components.phases.application.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = TestPhaseExecutor.NAME,
	description = ["Test the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class TestPhaseExecutor(tests: List<Test>) : PhaseExecutor<Test>(NAME, tests) {

	companion object {
		const val NAME = "test"
	}

}


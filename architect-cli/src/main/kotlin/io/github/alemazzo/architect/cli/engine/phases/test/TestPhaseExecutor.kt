package io.github.alemazzo.architect.cli.engine.phases.init

import io.github.alemazzo.architect.cli.api.phases.test.Test
import io.github.alemazzo.architect.cli.engine.phases.PhaseExecutor
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


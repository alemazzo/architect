package io.github.alemazzo.architect.cli.engine.phases.init

import io.github.alemazzo.architect.cli.api.phases.init.Init
import io.github.alemazzo.architect.cli.engine.phases.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = InitPhaseExecutor.NAME,
	description = ["Initialize the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class InitPhaseExecutor(initializers: List<Init>) : PhaseExecutor<Init>(NAME, initializers) {

	companion object {
		const val NAME = "init"
	}

}

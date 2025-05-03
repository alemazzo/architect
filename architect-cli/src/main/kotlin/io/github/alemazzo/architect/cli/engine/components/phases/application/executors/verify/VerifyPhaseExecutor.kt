package io.github.alemazzo.architect.cli.engine.components.phases.application.executors.verify

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.engine.components.phases.application.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = VerifyPhaseExecutor.NAME,
	description = ["Verify the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
class VerifyPhaseExecutor(verifiers: List<Verify>) : PhaseExecutor<Verify>(NAME, verifiers) {

	companion object {
		const val NAME = "verify"
	}

}


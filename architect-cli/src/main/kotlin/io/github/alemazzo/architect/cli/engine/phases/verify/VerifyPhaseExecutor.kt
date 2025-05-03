package io.github.alemazzo.architect.cli.engine.phases.verify

import io.github.alemazzo.architect.cli.api.phases.verify.Verify
import io.github.alemazzo.architect.cli.engine.phases.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = VerifyPhaseExecutor.NAME,
	description = ["Verify the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class VerifyPhaseExecutor(verifiers: List<Verify>) : PhaseExecutor<Verify>(NAME, verifiers) {

	companion object {
		const val NAME = "verify"
	}

}


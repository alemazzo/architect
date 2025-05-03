package io.github.alemazzo.architect.cli.engine.components.phases.application.executors.release

import io.github.alemazzo.architect.cli.engine.components.phases.api.release.Release
import io.github.alemazzo.architect.cli.engine.components.phases.application.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = ReleasePhaseExecutor.NAME,
	description = ["Release the application"],
	mixinStandardHelpOptions = true,
)
@Order(4)
class ReleasePhaseExecutor(releases: List<Release>) : PhaseExecutor<Release>(NAME, releases) {

	companion object {
		const val NAME = "release"
	}

}
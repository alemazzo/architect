package io.github.alemazzo.architect.cli.engine.phases.release

import io.github.alemazzo.architect.cli.api.phases.release.Release
import io.github.alemazzo.architect.cli.engine.phases.PhaseExecutor
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
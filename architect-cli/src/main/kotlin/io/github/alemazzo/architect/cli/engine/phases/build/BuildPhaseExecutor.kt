package io.github.alemazzo.architect.cli.engine.phases.build

import io.github.alemazzo.architect.cli.api.phases.build.Build
import io.github.alemazzo.architect.cli.engine.phases.PhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = BuildPhaseExecutor.NAME,
	description = ["Initialize the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class BuildPhaseExecutor(builds: List<Build>) : PhaseExecutor<Build>(NAME, builds) {

	companion object {
		const val NAME = "build"
	}

}


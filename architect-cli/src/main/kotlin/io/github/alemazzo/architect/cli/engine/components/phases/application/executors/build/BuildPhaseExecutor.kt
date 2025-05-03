package io.github.alemazzo.architect.cli.engine.components.phases.application.executors.build

import io.github.alemazzo.architect.cli.engine.components.phases.api.build.Build
import io.github.alemazzo.architect.cli.engine.components.phases.application.PhaseExecutor
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = BuildPhaseExecutor.NAME,
	description = ["Initialize the application"],
	mixinStandardHelpOptions = true,
)
class BuildPhaseExecutor(builds: List<Build>) : PhaseExecutor<Build>(NAME, builds) {

	companion object {
		const val NAME = "build"
	}

}


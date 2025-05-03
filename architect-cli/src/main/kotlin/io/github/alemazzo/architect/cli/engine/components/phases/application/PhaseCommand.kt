package io.github.alemazzo.architect.cli.engine.components.phases.application

import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.build.BuildPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.init.InitPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.release.ReleasePhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.run.RunPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.test.TestPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.verify.VerifyPhaseExecutor
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = "phases",
	description = ["Run the application phases"],
	subcommands = [
		InitPhaseExecutor::class,
		VerifyPhaseExecutor::class,
		BuildPhaseExecutor::class,
		TestPhaseExecutor::class,
		RunPhaseExecutor::class,
		ReleasePhaseExecutor::class,
	]
)
@Order(1)
class PhaseCommand : EngineComponent(
	name = "phases",
)
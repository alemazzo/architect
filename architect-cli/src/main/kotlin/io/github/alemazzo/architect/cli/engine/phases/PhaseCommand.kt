package io.github.alemazzo.architect.cli.engine.phases

import io.github.alemazzo.architect.cli.api.plugin.BasicPlugin
import io.github.alemazzo.architect.cli.engine.phases.build.BuildPhaseExecutor
import io.github.alemazzo.architect.cli.engine.phases.init.InitPhaseExecutor
import io.github.alemazzo.architect.cli.engine.phases.init.TestPhaseExecutor
import io.github.alemazzo.architect.cli.engine.phases.release.ReleasePhaseExecutor
import io.github.alemazzo.architect.cli.engine.phases.verify.RunPhaseExecutor
import io.github.alemazzo.architect.cli.engine.phases.verify.VerifyPhaseExecutor
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
class PhaseCommand : BasicPlugin(
	name = "phases",
)
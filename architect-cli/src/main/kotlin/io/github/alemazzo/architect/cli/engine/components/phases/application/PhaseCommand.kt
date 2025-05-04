package io.github.alemazzo.architect.cli.engine.components.phases.application

import io.github.alemazzo.architect.cli.engine.api.ArchitectCommand
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.build.BuildPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.init.InitPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.release.ReleasePhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.run.RunPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.test.TestPhaseExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.verify.VerifyPhaseExecutor
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = PhaseCommand.NAME,
	description = ["Execute the phase command"],
	mixinStandardHelpOptions = true,
	subcommands = [
		InitPhaseExecutor::class,
		VerifyPhaseExecutor::class,
		BuildPhaseExecutor::class,
		RunPhaseExecutor::class,
		TestPhaseExecutor::class,
		ReleasePhaseExecutor::class,
	]
)
class PhaseCommand(
) : ArchitectCommand {

	override fun run() {
		println("Running phase command")
	}

	companion object {
		const val NAME = "phases"
	}
}
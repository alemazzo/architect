package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.utils.log.WithLogger
import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Singleton
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Singleton
@Command(
	name = "launcher",
	description = ["Launch the Architect CLI"]
)
class ArchitectLauncher(
	val commandLine: CommandLine,
) : Runnable, WithLogger {

	@Parameters
	var args: Array<String> = emptyArray()

	init {
		logger.info("Creating Architect Launcher")
	}

	override fun run() {
		logger.info("Running Architect Launcher")
		commandLine.execute(*args)
	}

	companion object {

		const val name = "architect-cli"

		@JvmStatic
		fun main(args: Array<String>) {
			PicocliRunner.run(ArchitectLauncher::class.java, *args)
		}
	}
}
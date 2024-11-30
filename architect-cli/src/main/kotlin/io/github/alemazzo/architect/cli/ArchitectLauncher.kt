package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.log.WithLogger
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
	private val commandLine: CommandLine,
) : Runnable, WithLogger {

	@Parameters
	var args: Array<String> = emptyArray()

	override fun run() {
		logger.info("Running Architect Launcher")
		commandLine.execute(*args)
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			PicocliRunner.run(ArchitectLauncher::class.java, *args)
		}
	}
}
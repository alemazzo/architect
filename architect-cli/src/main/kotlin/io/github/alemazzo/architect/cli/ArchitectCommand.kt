package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.ProjectRunner
import io.github.alemazzo.architect.cli.commands.tasks.ChecksRunner
import io.github.alemazzo.architect.cli.commands.tasks.InitializersRunner
import io.github.alemazzo.architect.cli.commands.tasks.ReleasesRunner
import io.github.alemazzo.architect.cli.commands.tasks.RunnersRunner
import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine
import picocli.CommandLine.Command

@Command(
	name = "architect-cli",
	description = ["..."],
	mixinStandardHelpOptions = true,
	subcommands =
	[
		ProjectRunner::class,
		InitializersRunner::class,
		ChecksRunner::class,
		ReleasesRunner::class,
		RunnersRunner::class]
)
class ArchitectCommand : Runnable {

	override fun run() {
		CommandLine.usage(this, System.out)
	}

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			PicocliRunner.run(ArchitectCommand::class.java, *args)
		}
	}
}

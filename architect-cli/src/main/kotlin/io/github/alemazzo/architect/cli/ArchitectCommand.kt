package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.CheckRunner
import io.github.alemazzo.architect.cli.commands.InitRunner
import io.github.alemazzo.architect.cli.commands.ProjectRunner
import io.github.alemazzo.architect.cli.commands.ReleaseRunner
import io.github.alemazzo.architect.cli.commands.RunRunner
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
		InitRunner::class,
		CheckRunner::class,
		ReleaseRunner::class,
		RunRunner::class]
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

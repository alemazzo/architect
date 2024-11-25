package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.CheckCommand
import io.github.alemazzo.architect.cli.commands.InitCommand
import io.github.alemazzo.architect.cli.commands.ProjectCommand
import io.github.alemazzo.architect.cli.commands.ReleaseCommand
import io.github.alemazzo.architect.cli.commands.RunCommand
import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine
import picocli.CommandLine.Command

@Command(
	name = "architect-cli",
	description = ["..."],
	mixinStandardHelpOptions = true,
	subcommands =
	[
		ProjectCommand::class,
		InitCommand::class,
		CheckCommand::class,
		ReleaseCommand::class,
		RunCommand::class]
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

package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.commands.ProjectRunner
import io.github.alemazzo.architect.cli.commands.tasks.ChecksRunner
import io.github.alemazzo.architect.cli.commands.tasks.InitializersRunner
import io.github.alemazzo.architect.cli.commands.tasks.ReleasesRunner
import io.github.alemazzo.architect.cli.commands.tasks.RunnersRunner
import io.github.alemazzo.architect.cli.context.Context
import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Inject
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

	@Inject
	lateinit var context: Context

	@Inject
	lateinit var plugins: List<Plugin<*>>

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

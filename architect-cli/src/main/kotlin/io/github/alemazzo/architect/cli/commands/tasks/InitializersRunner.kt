package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.init.ArchitectInitializer
import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.configuration.RequireContext
import jakarta.inject.Inject
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Command(
	name = "init",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
@Singleton
@RequireContext
@ArchitectInitializer
class InitializersRunner :
	ArchitectCommand {

	@Inject
	lateinit var initializers: List<Initializer>

	override fun run() {
		initializers.forEach { it.run() }
		println("All initializers passed")
	}

}


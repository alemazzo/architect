package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.init.Initializer
import jakarta.inject.Inject
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Command(
	name = "init",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
@Singleton
class InitializersRunner :
	ArchitectCommand {

	@Inject
	lateinit var initializers: List<Initializer>

	override fun run() {
		initializers.forEach { it.run() }
		logger.info("All initializers passed")
	}

}


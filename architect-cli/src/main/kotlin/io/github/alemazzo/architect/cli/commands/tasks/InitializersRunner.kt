package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.plugins.architect.ArchitectConfigurator
import io.github.alemazzo.architect.cli.utils.GroupRunner
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "init",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class InitializersRunner(private val configurator: ArchitectConfigurator, initializers: List<Initializer>) :
	GroupRunner(initializers),
	ArchitectCommand {

	override fun run() {
		println("Hello from Init!")
		println("Running configurator")
		configurator.run()
		println("Configurator loaded")
		super.run()
		println("All initializers passed")
	}

}


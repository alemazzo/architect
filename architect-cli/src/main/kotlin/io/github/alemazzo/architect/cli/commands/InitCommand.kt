package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.init.Initializer
import io.github.alemazzo.architect.cli.configuration.ArchitectConfigurator
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "init",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class InitCommand(private val initializers: List<Initializer>, private val configurator: ArchitectConfigurator) :
	Runnable {

	override fun run() {
		println("Hello from Init!")
		println("Running configurator")
		configurator.run()
		println("Configurator loaded")
		println("Running initializers")
		initializers.forEach(Initializer::run)
		println("All initializers passed")
	}

}


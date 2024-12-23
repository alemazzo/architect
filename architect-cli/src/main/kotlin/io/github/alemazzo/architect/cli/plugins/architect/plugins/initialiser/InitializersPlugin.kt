package io.github.alemazzo.architect.cli.plugins.architect.plugins.initialiser

import io.github.alemazzo.architect.cli.api.architect.init.Initializer
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command


@Command(
	name = "init",
	description = ["Initialize the application"],
	mixinStandardHelpOptions = true,
)
@Singleton
@Order(1)
class InitializersPlugin(private val initializers: List<Initializer>) :
	Plugin<Void>(name) {
	override val context: Void? = null

	companion object {
		const val name = "init"
	}


	override fun run() {
		initializers.forEach { it.run() }
		logger.info("All initializers passed")
	}

}


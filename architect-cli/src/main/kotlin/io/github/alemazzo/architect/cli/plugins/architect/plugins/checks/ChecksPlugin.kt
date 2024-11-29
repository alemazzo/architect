package io.github.alemazzo.architect.cli.plugins.architect.plugins.checks

import io.github.alemazzo.architect.cli.api.architect.check.Check
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "check",
	description = ["Run the checks"],
	mixinStandardHelpOptions = true,
)
@Order(2)
class ChecksPlugin(private val checks: List<Check>) : Plugin<Void>(name) {

	override val context: Void? = null

	companion object {
		const val name = "check"
	}

	override fun run() {
		checks.forEach { it.run() }
		logger.info("All checks passed")
	}

}



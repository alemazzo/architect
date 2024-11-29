package io.github.alemazzo.architect.cli.plugins.architect.plugins.release

import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.api.command.release.Releaser
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "release",
	description = ["Release the application"],
	mixinStandardHelpOptions = true,
)
@Order(4)
class ReleasePlugin(private val releases: List<Releaser>) : Plugin<Void>(name) {
	override val context: Void? = null

	companion object {
		const val name = "release"
	}

	override fun run() {
		releases.forEach { it.run() }
		logger.info("All releases passed")
	}

}
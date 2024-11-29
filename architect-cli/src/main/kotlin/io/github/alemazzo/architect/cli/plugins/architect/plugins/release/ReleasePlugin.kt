package io.github.alemazzo.architect.cli.plugins.architect.plugins.release

import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.api.architect.release.Releaser
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import picocli.CommandLine.Command

data class ReleaseConfiguration(
	val name: String = "release",
	val description: String = "Release the application",
)

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
package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.release.Releaser
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Command(
	name = "release",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class ReleasesRunner : ArchitectCommand {
	@Inject
	lateinit var releases: List<Releaser>

	override fun run() {
		releases.forEach { it.run() }
		logger.info("All releases passed")
	}
}
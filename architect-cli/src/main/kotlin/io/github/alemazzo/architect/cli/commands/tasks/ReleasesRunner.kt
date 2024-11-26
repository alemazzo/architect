package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.release.ArchitectReleaser
import io.github.alemazzo.architect.cli.api.command.release.Releaser
import io.github.alemazzo.architect.cli.configuration.RequireContext
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Command(
	name = "release",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
@RequireContext
@ArchitectReleaser
class ReleasesRunner : ArchitectCommand {
	@Inject
	lateinit var releases: List<Releaser>

	override fun run() {
		releases.forEach { it.run() }
		println("All releases passed")
	}
}
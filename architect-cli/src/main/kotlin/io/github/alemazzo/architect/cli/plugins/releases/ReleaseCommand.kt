package io.github.alemazzo.architect.cli.plugins.releases

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.releases.application.GithubReleaser
import io.github.alemazzo.architect.cli.plugins.releases.context.ReleaseContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ReleaseCommand.NAME,
	description = ["Release the application"],
	subcommands = [
		GithubReleaser::class,
	]
)
class ReleaseCommand() : Plugin<ReleaseContext>(NAME) {
	companion object {
		const val NAME = "release"
	}
}
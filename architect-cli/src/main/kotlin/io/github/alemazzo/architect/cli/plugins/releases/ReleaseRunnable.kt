package io.github.alemazzo.architect.cli.plugins.releases

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.releases.application.GithubReleaser
import io.github.alemazzo.architect.cli.plugins.releases.context.ReleaseContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ReleaseRunnable.NAME,
	description = ["Release the application"],
	subcommands = [
		GithubReleaser::class,
	]
)
class ReleaseRunnable() : PluginCommand<ReleaseContext>(NAME) {
	companion object {
		const val NAME = "releases"
	}
}
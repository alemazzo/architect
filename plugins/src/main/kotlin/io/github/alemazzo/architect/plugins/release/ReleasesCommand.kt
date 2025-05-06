package io.github.alemazzo.architect.plugins.release

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.plugins.release.application.GithubReleaseTask
import io.github.alemazzo.architect.plugins.release.context.ReleaseContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = ReleasesCommand.NAME,
	description = ["Release the application"],
	subcommands = [
		GithubReleaseTask::class,
	]
)
class ReleasesCommand : PluginCommand<ReleaseContext>(NAME) {
	companion object {
		const val NAME = "releases"
	}
}
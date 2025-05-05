package io.github.alemazzo.architect.cli.commands.releases

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.releases.application.GithubReleaseTask
import io.github.alemazzo.architect.cli.commands.releases.context.ReleaseContext
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
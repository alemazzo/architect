package io.github.alemazzo.architect.cli.plugins.releases

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.releases.application.GithubReleaser
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsInitCommand
import io.github.alemazzo.architect.cli.plugins.scripts.application.ScriptsVerifyCommand
import io.github.alemazzo.architect.cli.plugins.scripts.context.ScriptsContext
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
class ReleaseCommand() : Plugin<ScriptsContext>(NAME) {
	companion object {
		const val NAME = "release"
	}
}
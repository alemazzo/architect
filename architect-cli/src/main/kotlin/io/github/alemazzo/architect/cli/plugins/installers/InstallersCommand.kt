package io.github.alemazzo.architect.cli.plugins.installers

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.installers.application.InstallerInitCommand
import io.github.alemazzo.architect.cli.plugins.installers.context.InstallersContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = InstallersCommand.name,
	description = ["Run the installers commands"],
	subcommands = [
		InstallerInitCommand::class,
	]
)
class InstallersCommand : Plugin<InstallersContextHolder>(name) {
	companion object {
		const val name = "installers"
	}
}
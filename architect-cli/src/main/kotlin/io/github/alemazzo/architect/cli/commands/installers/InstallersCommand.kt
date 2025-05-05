package io.github.alemazzo.architect.cli.commands.installers

import io.github.alemazzo.architect.cli.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.installers.application.InstallerInitTask
import io.github.alemazzo.architect.cli.commands.installers.context.InstallersContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = InstallersCommand.name,
	description = ["Run the installers command"],
	subcommands = [
		InstallerInitTask::class,
	]
)
class InstallersCommand : PluginCommand<InstallersContextHolder>(name) {
	companion object {
		const val name = "installers"
	}
}
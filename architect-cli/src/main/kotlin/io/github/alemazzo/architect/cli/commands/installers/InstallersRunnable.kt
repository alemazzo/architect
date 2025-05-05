package io.github.alemazzo.architect.cli.commands.installers

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.installers.application.InstallerInitTaskTask
import io.github.alemazzo.architect.cli.plugins.installers.context.InstallersContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = InstallersRunnable.name,
	description = ["Run the installers command"],
	subcommands = [
		InstallerInitTaskTask::class,
	]
)
class InstallersRunnable : PluginCommand<InstallersContextHolder>(name) {
	companion object {
		const val name = "installers"
	}
}
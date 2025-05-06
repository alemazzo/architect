package io.github.alemazzo.architect.core.installers

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.core.installers.context.InstallersContextHolder
import io.github.alemazzo.architect.core.installers.application.InstallerInitTask
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
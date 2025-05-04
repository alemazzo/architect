package io.github.alemazzo.architect.cli.plugins.installers

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.installers.application.InstallerInitTask
import io.github.alemazzo.architect.cli.plugins.installers.context.InstallersContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = InstallersTask.name,
	description = ["Run the installers commands"],
	subcommands = [
		InstallerInitTask::class,
	]
)
class InstallersTask : Plugin<InstallersContextHolder>(name) {
	companion object {
		const val name = "installers"
	}
}
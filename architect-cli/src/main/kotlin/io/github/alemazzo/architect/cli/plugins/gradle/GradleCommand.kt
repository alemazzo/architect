package io.github.alemazzo.architect.cli.plugins.gradle

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleBuild
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleTestCommand
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContextHolder
import picocli.CommandLine.Command

@Command(
	name = GradleCommand.name,
	subcommands = [
		ArchitectGradleBuild::class,
		ArchitectGradleTestCommand::class
	]
)
class GradleCommand : Plugin<GradleContextHolder>(name) {
	companion object {
		const val name = "gradle"
	}
}
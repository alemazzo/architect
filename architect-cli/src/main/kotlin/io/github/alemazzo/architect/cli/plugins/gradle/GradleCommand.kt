package io.github.alemazzo.architect.cli.plugins.gradle

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleBuildCommand
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleRunCommand
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleTestCommand
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = GradleCommand.name,
	subcommands = [
		ArchitectGradleBuildCommand::class,
		ArchitectGradleTestCommand::class,
		ArchitectGradleRunCommand::class,
	]
)
class GradleCommand : Plugin<GradleContextHolder>(name) {
	companion object {
		const val name = "gradle"
	}
}
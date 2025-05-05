package io.github.alemazzo.architect.cli.commands.gradle

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.commands.gradle.application.ArchitectGradleBuildTaskTask
import io.github.alemazzo.architect.cli.commands.gradle.application.ArchitectGradleRunTaskTask
import io.github.alemazzo.architect.cli.commands.gradle.application.ArchitectGradleTestTaskTask
import io.github.alemazzo.architect.cli.commands.gradle.context.GradleContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = GradleRunnable.name,
	subcommands = [
		ArchitectGradleBuildTaskTask::class,
		ArchitectGradleTestTaskTask::class,
		ArchitectGradleRunTaskTask::class,
	]
)
class GradleRunnable : PluginCommand<GradleContextHolder>(name) {
	companion object {
		const val name = "gradle"
	}
}
package io.github.alemazzo.architect.cli.plugins.gradle

import io.github.alemazzo.architect.cli.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.gradle.application.GradleBuildTask
import io.github.alemazzo.architect.cli.plugins.gradle.application.GradleRunTask
import io.github.alemazzo.architect.cli.plugins.gradle.application.GradleTestTask
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = GradleCommand.name,
	subcommands = [
		GradleBuildTask::class,
		GradleTestTask::class,
		GradleRunTask::class,
	]
)
class GradleCommand : PluginCommand<GradleContextHolder>(name) {
	companion object {
		const val name = "gradle"
	}
}
package io.github.alemazzo.architect.plugins.gradle

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.plugins.gradle.application.GradleBuildTask
import io.github.alemazzo.architect.plugins.gradle.application.GradleRunTask
import io.github.alemazzo.architect.plugins.gradle.application.GradleTestTask
import io.github.alemazzo.architect.plugins.gradle.context.GradleContextHolder
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
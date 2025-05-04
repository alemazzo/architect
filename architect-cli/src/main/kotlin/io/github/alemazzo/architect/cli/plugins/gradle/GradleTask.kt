package io.github.alemazzo.architect.cli.plugins.gradle

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleBuildTask
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleRunTask
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleTestTask
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = GradleTask.name,
	subcommands = [
		ArchitectGradleBuildTask::class,
		ArchitectGradleTestTask::class,
		ArchitectGradleRunTask::class,
	]
)
class GradleTask : Plugin<GradleContextHolder>(name) {
	companion object {
		const val name = "gradle"
	}
}
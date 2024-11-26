package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.plugins.gradle.GradlePlugin
import io.github.alemazzo.architect.cli.plugins.gradle.configuration.GradleContext
import io.github.alemazzo.architect.cli.plugins.gradle.configuration.ProjectContext
import io.github.alemazzo.architect.cli.plugins.gradle.utils.GradleExecutor
import jakarta.inject.Singleton

@Singleton
@GradlePlugin
class ArchitectGradleTestCommand(val context: GradleContext, private val gradleExecutor: GradleExecutor) :
	Check {
	override fun run() {
		println("Executing gradle test")
		context.projects.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		println("Executing gradle test on project: ${project.name}")
		gradleExecutor.execute(project, arrayOf("test"))
	}
}
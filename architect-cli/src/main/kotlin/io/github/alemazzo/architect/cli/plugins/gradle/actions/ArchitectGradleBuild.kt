package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.plugins.gradle.GradlePlugin
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import io.github.alemazzo.architect.cli.plugins.gradle.utils.GradleExecutor
import jakarta.inject.Singleton

@Singleton
@GradlePlugin
class ArchitectGradleBuild(val context: GradleContext, private val gradleExecutor: GradleExecutor) :
	Check, Initializer {

	override fun run() {
		println("Executing gradle build")
		context.projects.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		println("Executing gradle build on project: ${project.name}")
		gradleExecutor.execute(project, arrayOf("build"))
	}
}
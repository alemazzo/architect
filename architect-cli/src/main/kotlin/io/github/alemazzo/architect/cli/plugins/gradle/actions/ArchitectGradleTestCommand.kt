package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.phases.verify.Verify
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import io.github.alemazzo.architect.cli.plugins.gradle.utils.GradleExecutor
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "test")
class ArchitectGradleTestCommand(val context: GradleContext, private val gradleExecutor: GradleExecutor) :
	Verify {
	override fun run() {
		logger.info("Executing gradle test")
		context.projects.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		logger.info("Executing gradle test on project: ${project.name}")
		gradleExecutor.execute(project, arrayOf("test"))
	}
}
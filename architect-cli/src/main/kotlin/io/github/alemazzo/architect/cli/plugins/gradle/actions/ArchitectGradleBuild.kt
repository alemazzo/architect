package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.phases.verify.Verify
import io.github.alemazzo.architect.cli.api.phases.init.Init
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import io.github.alemazzo.architect.cli.plugins.gradle.utils.GradleExecutor
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "build")
class ArchitectGradleBuild(val context: GradleContext, private val gradleExecutor: GradleExecutor) :
	Verify, Init {

	override fun run() {
		logger.info("Executing gradle build")
		context.projects.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		logger.info("Executing gradle build for project ${project.name}")
		gradleExecutor.execute(project, arrayOf("build"))
	}
}
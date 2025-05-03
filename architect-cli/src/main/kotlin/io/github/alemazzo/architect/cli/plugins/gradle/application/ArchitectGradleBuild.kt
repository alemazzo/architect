package io.github.alemazzo.architect.cli.plugins.gradle.application

import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import io.github.alemazzo.architect.cli.plugins.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "build")
class ArchitectGradleBuild(val context: GradleContext, private val gradleExecutor: GradleExecutor) :
	Verify, Init {

	private val logger = getLogger()

	override fun run() {
		logger.info("Executing gradle build")
		context.projects.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		logger.info("Executing gradle build for project ${project.name}")
		gradleExecutor.execute(project, arrayOf("build"))
	}
}
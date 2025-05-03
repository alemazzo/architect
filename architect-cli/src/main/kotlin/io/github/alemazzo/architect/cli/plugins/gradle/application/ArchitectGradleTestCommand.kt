package io.github.alemazzo.architect.cli.plugins.gradle.application

import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.github.alemazzo.architect.cli.engine.components.phases.api.test.Test
import io.github.alemazzo.architect.cli.plugins.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "test")
class ArchitectGradleTestCommand(val context: GradleContextHolder, private val gradleExecutor: GradleExecutor) :
	Test {

	override fun run() {
		println("Executing gradle test")
		context.gradle?.projects?.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		println("Executing gradle test on project: ${project.name}")
		gradleExecutor.execute(project, arrayOf("test"))
	}
}
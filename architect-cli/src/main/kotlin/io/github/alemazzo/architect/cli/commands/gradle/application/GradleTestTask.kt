package io.github.alemazzo.architect.cli.commands.gradle.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.test.TestTask
import io.github.alemazzo.architect.cli.commands.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.cli.commands.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.cli.commands.gradle.context.ProjectContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "test")
class GradleTestTask(val context: GradleContextHolder, private val gradleExecutor: GradleExecutor) :
	TestTask {

	override fun run() {
		println("Executing gradle test")
		context.gradle?.projects?.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		println("Executing gradle test on project: ${project.name}")
		gradleExecutor.execute(project, arrayOf("test"))
	}
}
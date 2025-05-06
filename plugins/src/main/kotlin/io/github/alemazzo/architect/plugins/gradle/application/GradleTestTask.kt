package io.github.alemazzo.architect.plugins.gradle.application

import io.github.alemazzo.architect.engine.tasks.api.test.TestTask
import io.github.alemazzo.architect.plugins.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.plugins.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.plugins.gradle.context.ProjectContext
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
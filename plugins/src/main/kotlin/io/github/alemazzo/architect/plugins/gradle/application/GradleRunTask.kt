package io.github.alemazzo.architect.plugins.gradle.application

import io.github.alemazzo.architect.engine.tasks.api.run.RunTask
import io.github.alemazzo.architect.plugins.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.plugins.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.plugins.gradle.context.ProjectContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "run")
class GradleRunTask(val context: GradleContextHolder, private val gradleExecutor: GradleExecutor) :
	RunTask {

	override fun run() {
		println("Executing gradle run")
		context.gradle?.projects?.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		println("Executing gradle run for project ${project.name}")
		gradleExecutor.execute(project, arrayOf("run"))
	}
}
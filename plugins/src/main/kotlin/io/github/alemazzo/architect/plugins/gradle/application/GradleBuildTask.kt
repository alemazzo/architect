package io.github.alemazzo.architect.plugins.gradle.application

import io.github.alemazzo.architect.engine.tasks.api.build.BuildTask
import io.github.alemazzo.architect.plugins.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.plugins.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.plugins.gradle.context.ProjectContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "build")
class GradleBuildTask(val context: GradleContextHolder, private val gradleExecutor: GradleExecutor) :
	BuildTask {

	override fun run() {
		println("Executing gradle build")
		context.gradle?.projects?.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		println("Executing gradle build for project ${project.name}")
		gradleExecutor.execute(project, arrayOf("build"))
	}
}
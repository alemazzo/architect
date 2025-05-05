package io.github.alemazzo.architect.cli.commands.gradle.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.build.BuildTask
import io.github.alemazzo.architect.cli.commands.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.cli.commands.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.cli.commands.gradle.context.ProjectContext
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
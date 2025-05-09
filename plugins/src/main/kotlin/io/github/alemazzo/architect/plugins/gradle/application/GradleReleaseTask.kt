package io.github.alemazzo.architect.plugins.gradle.application

import io.github.alemazzo.architect.engine.tasks.api.release.ReleaseTask
import io.github.alemazzo.architect.engine.tasks.api.run.RunTask
import io.github.alemazzo.architect.plugins.gradle.application.utils.GradleExecutor
import io.github.alemazzo.architect.plugins.gradle.context.GradleContextHolder
import io.github.alemazzo.architect.plugins.gradle.context.ProjectContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "github-packages-release")
class GradleReleaseTask(val context: GradleContextHolder, private val gradleExecutor: GradleExecutor) :
	ReleaseTask {

	override fun run() {
		println("Executing gradle release")
		context.gradle?.projects?.forEach(::runSingleProject)
	}

	private fun runSingleProject(project: ProjectContext) {
		if (!project.githubPackageRelease) {
			println("Skipping project ${project.name} because it has no github package release")
			return
		}
		println("Executing gradle release for project ${project.name}")
		gradleExecutor.execute(project, arrayOf("publishGprPublicationToGitHubPackagesRepository"))
	}
}
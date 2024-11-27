package io.github.alemazzo.architect.cli.plugins.gradle.utils

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import io.github.alemazzo.architect.cli.utils.execution.CommandExecutor
import jakarta.inject.Singleton

@Singleton
class GradleExecutor(
	private val commandExecutor: CommandExecutor,
) : Architect {

	private fun getCommand(command: String, args: Array<String>): String {
		return "$command ${args.joinToString(" ")}"
	}

	fun execute(project: ProjectContext, args: Array<String>): Boolean {
		if (project.path == null) {
			logger.info("Project path is not set for project: ${project.name}")
			logger.info("Using name as path")
			project.path = project.name
		}
		logger.info("Executing Gradle command: ${project.command} ${args.joinToString(" ")} in ${project.path}")
		return commandExecutor.execute(getCommand(project.command, args), project.path)
	}
}
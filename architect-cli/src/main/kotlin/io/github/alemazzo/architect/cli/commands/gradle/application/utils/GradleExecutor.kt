package io.github.alemazzo.architect.cli.commands.gradle.application.utils

import io.github.alemazzo.architect.cli.engine.utils.log.getLogger
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.commands.gradle.context.ProjectContext
import jakarta.inject.Singleton

@Singleton
class GradleExecutor(
	private val commandExecutor: CommandExecutor,
)  {

	private val logger = getLogger()

	private fun getCommand(command: String, args: Array<String>): String {
		return "$command ${args.joinToString(" ")}"
	}

	fun execute(project: ProjectContext, args: Array<String>) {
		if (project.path == null) {
			logger.info("Project path is not set for project: ${project.name}")
			logger.info("Using name as path")
			project.path = project.name
		}
		logger.info("Executing Gradle phases: ${project.command} ${args.joinToString(" ")} in ${project.path}")
		commandExecutor.execute(getCommand(project.command, args), project.path)
	}
}
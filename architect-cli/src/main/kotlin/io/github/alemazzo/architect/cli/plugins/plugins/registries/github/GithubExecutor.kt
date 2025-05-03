package io.github.alemazzo.architect.cli.plugins.plugins.registries.github

import io.github.alemazzo.architect.cli.api.log.WithLogger
import io.github.alemazzo.architect.cli.implementation.execution.CommandExecutor
import jakarta.inject.Singleton

data class Repository(
	val owner: String,
	val name: String,
)

data class GithubConfiguration(
	val repo: Repository,
	val command: String,
)

@Singleton
class GithubExecutor(
	private val commandExecutor: CommandExecutor,
) : WithLogger {

	fun getTempFolder(): String {
		return ".phases/tmp"
	}

	fun getPath(configuration: GithubConfiguration): String {
		return "${getTempFolder()}/${configuration.repo.name}"
	}

	private fun getHttpsUrl(configuration: GithubConfiguration): String {
		return "https://github.com/${configuration.repo.owner}/${configuration.repo.name}"
	}

	fun run(configuration: GithubConfiguration, preCommand: (CommandExecutor) -> Unit = {}) {
		val tempFolder = getTempFolder()
		val folderPath = getPath(configuration)
		val httpsUrl = getHttpsUrl(configuration)

		logger.info("Running Github Plugin Command")
		logger.info("Repo: ${configuration.repo.owner}/${configuration.repo.name}")

		// Execute a phases that verify if the tmp directory exists and if not, create it
		logger.info("Creating tmp directory if not exists")
		commandExecutor.execute("mkdir -p $tempFolder")

		// Clone the repository inside the tmp directory
		logger.info("Cloning the repository")
		commandExecutor.execute("git clone $httpsUrl $folderPath")

		// Remove the .git directory
		logger.info("Removing the .git directory")
		commandExecutor.execute("rm -rf $folderPath/.git")

		// Execute the pre-command
		logger.info("Executing the pre-command")
		preCommand(commandExecutor)

		// Execute the phases inside the repository
		logger.info("Executing the phases")
		commandExecutor.execute(configuration.command, folderPath)

		// Remove the tmp directory
		logger.info("Removing the tmp phases directory")
		commandExecutor.execute("rm -rf $folderPath")

		// Remove the tmp directory if it's empty
		logger.info("Removing the tmp directory if it's empty")
		commandExecutor.execute("rmdir $tempFolder")

	}

}
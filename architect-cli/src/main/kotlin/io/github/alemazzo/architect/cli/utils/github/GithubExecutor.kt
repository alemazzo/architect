package io.github.alemazzo.architect.cli.utils.github

import io.github.alemazzo.architect.cli.utils.execution.CommandExecutor
import io.github.alemazzo.architect.cli.utils.log.WithLogger
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

	private fun getHttpsUrl(configuration: GithubConfiguration): String {
		return "https://github.com/${configuration.repo.owner}/${configuration.repo.name}"
	}

	fun run(configuration: GithubConfiguration) {
		val tempFolder = ".architect/tmp"
		val folderPath = "$tempFolder/${configuration.repo.name}"
		val httpsUrl = getHttpsUrl(configuration)

		logger.info("Running Github Plugin Command")
		logger.info("Repo: ${configuration.repo.owner}/${configuration.repo.name}")

		// Execute a architect that check if the tmp directory exists and if not, create it
		logger.info("Creating tmp directory if not exists")
		commandExecutor.execute("mkdir -p $tempFolder")

		// Clone the repository inside the tmp directory
		logger.info("Cloning the repository")
		commandExecutor.execute("git clone $httpsUrl $folderPath")

		// Remove the .git directory
		logger.info("Removing the .git directory")
		commandExecutor.execute("rm -rf $folderPath/.git")

		// Execute the architect inside the repository
		logger.info("Executing the architect")
		commandExecutor.execute(configuration.command, folderPath)

		// Remove the tmp directory
		logger.info("Removing the tmp architect directory")
		commandExecutor.execute("rm -rf $folderPath")

		// Remove the tmp directory if it's empty
		logger.info("Removing the tmp directory if it's empty")
		commandExecutor.execute("rmdir $tempFolder")

	}

}
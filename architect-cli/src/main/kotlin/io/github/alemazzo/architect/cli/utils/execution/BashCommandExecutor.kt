package io.github.alemazzo.architect.cli.utils.execution

import io.github.alemazzo.architect.cli.utils.log.WithLogger
import jakarta.inject.Singleton

@Singleton
open class BashCommandExecutor : CommandExecutor, WithLogger {


	private fun executeCommand(command: String, workingDir: String? = null): Pair<Int, String> {
		val processBuilder = ProcessBuilder(command.split(" "))
		if (workingDir != null) {
			processBuilder.directory(java.io.File(workingDir))
		}
		val process = processBuilder.start()
		val result = process.inputStream.bufferedReader().readText()
		logBanner()
		logger.info("************ Command output ************")
		result.lines().forEach { logger.info(it) }
		logger.info("******** End of command output *********")
		logBanner()
		return Pair(process.waitFor(), result)
	}

	private fun logBanner() {
		val count = 5
		for (i in 1..count) {
			logger.info("************************************")
		}
	}

	override fun execute(command: String, workingDir: String?): Boolean {
		logger.info("Executing command: $command in $workingDir")
		val (exitCode, _) = executeCommand(command, workingDir)
		logger.info("Command executed with exit code $exitCode")
		return exitCode == 0
	}
}
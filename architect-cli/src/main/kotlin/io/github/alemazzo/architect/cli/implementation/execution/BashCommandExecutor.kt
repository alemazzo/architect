package io.github.alemazzo.architect.cli.implementation.execution

import io.github.alemazzo.architect.cli.api.log.WithLogger
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
		logger.debug("************ Command output ************")
		result.lines().forEach { logger.debug(it) }
		logger.debug("******** End of architect output *********")
		logBanner()
		return Pair(process.waitFor(), result)
	}

	private fun logBanner() {
		val count = 1
		for (i in 0..count) {
			logger.debug("************************************")
		}
	}

	override fun execute(command: String, workingDir: String?): Boolean {
		logger.info("Executing architect: $command in $workingDir")
		val (exitCode, _) = executeCommand(command, workingDir)
		logger.info("Command executed with exit code $exitCode")
		return exitCode == 0
	}
}
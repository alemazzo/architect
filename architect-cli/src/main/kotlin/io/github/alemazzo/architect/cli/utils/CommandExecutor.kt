package io.github.alemazzo.architect.cli.utils

import jakarta.inject.Singleton
import java.io.BufferedReader

@Singleton
class CommandExecutor {

	var disabled: Boolean = false

	private fun executeCommand(command: String, workingDir: String? = null): Pair<Int, String> {
		val processBuilder = ProcessBuilder(command.split(" "))
		if (workingDir != null) {
			processBuilder.directory(java.io.File(workingDir))
		}
		processBuilder.redirectErrorStream(true) // Merge standard output and error streams
		val process = processBuilder.start()
		val result = process.inputStream.bufferedReader().use(BufferedReader::readText)
		return Pair(process.waitFor(), result)
	}

	fun execute(command: String, log: Boolean = false, workingDir: String? = null): Boolean {
		println("[CommandExecutor] Executing command: $command")
		if (disabled) {
			println("[CommandExecutor] Command execution disabled")
			return true
		}
		val (exitCode, result) = executeCommand(command, workingDir)
		if (exitCode != 0) {
			println("Command failed with exit code $exitCode")
			println(result)
		}
		if (log) {
			println(result)
		}
		return exitCode == 0
	}
}
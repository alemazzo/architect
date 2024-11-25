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
		// Redirect output to stdout
		processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
		val process = processBuilder.start()
		val result = process.inputStream.bufferedReader().use(BufferedReader::readText)
		return Pair(process.waitFor(), result)
	}

	fun execute(command: String, log: Boolean = false, workingDir: String? = null): Boolean {
		println("[CommandExecutor] Executing command: $command in $workingDir")
		if (disabled) {
			println("[CommandExecutor] Command execution disabled")
			return true
		}
		val (exitCode, result) = executeCommand(command, workingDir)
		println("[CommandExecutor] Command execution result: $exitCode")
		println(result)
		return exitCode == 0
	}
}
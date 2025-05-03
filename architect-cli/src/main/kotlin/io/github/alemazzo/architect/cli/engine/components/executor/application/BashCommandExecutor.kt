package io.github.alemazzo.architect.cli.engine.components.executor.application

import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import jakarta.inject.Singleton
import java.io.File

@Singleton
open class BashCommandExecutor : CommandExecutor {

	private fun String.splitToCommandParts(): List<String> {
		val regex = Regex("""[^\s"']+|"([^"]*)"|'([^']*)'""")
		return regex.findAll(this)
			.map { it.groupValues[0].trim('"', '\'') }
			.toList()
	}

	private fun executeCommand(command: String, workingDir: String? = null): Pair<Int, String> {
		val processBuilder = ProcessBuilder(command.splitToCommandParts())
		if (workingDir != null) {
			processBuilder.directory(File(workingDir))
		}
		processBuilder.redirectErrorStream(true)
		val process = processBuilder.start()
		val outputBuilder = StringBuilder()
		val outputThread = Thread {
			process.inputStream.bufferedReader().useLines { lines ->
				lines.forEach { line ->
					println(line) // Optionally log each line
					outputBuilder.appendLine(line)
				}
			}
		}
		outputThread.start()

		// Wait for the process to complete
		val exitCode = process.waitFor()

		// Ensure the output thread has finished processing
		outputThread.join()

		val result = outputBuilder.toString()
		return Pair(exitCode, result)
	}

	override fun execute(command: String, workingDir: String?): Boolean {
		println("Executing phases: $command in $workingDir")
		val (exitCode, result) = executeCommand(command, workingDir)
		if (exitCode != 0) {
			println("Command failed with exit code $exitCode")
			println("Command output: $result")
		}
		return exitCode == 0
	}
}
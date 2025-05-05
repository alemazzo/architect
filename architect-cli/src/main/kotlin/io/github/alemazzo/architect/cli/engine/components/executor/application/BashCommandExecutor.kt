package io.github.alemazzo.architect.cli.engine.components.executor.application

import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import jakarta.inject.Singleton
import java.io.File
import kotlin.system.exitProcess

@Singleton
open class BashCommandExecutor : CommandExecutor {

	private fun executeCommand(command: String, workingDir: String? = null): Pair<Int, String> {
		val processBuilder = ProcessBuilder("sh", "-c", command)
		if (workingDir != null) {
			processBuilder.directory(File(workingDir))
		}
		processBuilder.redirectErrorStream(true)
		val process = processBuilder.start()

		val outputBuilder = StringBuilder()
		process.inputStream.bufferedReader().useLines { lines ->
			lines.forEach { outputBuilder.appendLine(it) }
		}

		val exitCode = process.waitFor()
		return exitCode to outputBuilder.toString().trim()
	}

	override fun execute(command: String, workingDir: String?) {
		println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
		println("▶ Command:")
		println("  ${if (workingDir != null) "cd $workingDir && " else ""}$command")
		println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")

		val (exitCode, result) = executeCommand(command, workingDir)

		if (exitCode == 0) {
			println("✅ Success (exit code: $exitCode)")
			println("Output:")
			println(result)
		} else {
			println("❌ Failed (exit code: $exitCode)")
			println("Output:")
			println(result)
			exitProcess(-1)
		}
	}
}

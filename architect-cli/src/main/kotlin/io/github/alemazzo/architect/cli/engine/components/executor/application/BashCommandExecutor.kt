package io.github.alemazzo.architect.cli.engine.components.executor.application

import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import jakarta.inject.Singleton
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean

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
		val reader = process.inputStream.bufferedReader()

		val running = AtomicBoolean(true)
		val spinnerChars = listOf("⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏")
		val spinnerThread = Thread {
			var i = 0
			while (running.get()) {
				print("\r${spinnerChars[i++ % spinnerChars.size]} Running...")
				Thread.sleep(500)
			}
		}

		spinnerThread.start()

		reader.useLines { lines ->
			lines.forEach { outputBuilder.appendLine(it) }
		}

		val exitCode = process.waitFor()
		running.set(false)
		spinnerThread.join()
		print("\r") // clear spinner line

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
			throw RuntimeException("Command failed with exit code $exitCode")
		}
	}
}

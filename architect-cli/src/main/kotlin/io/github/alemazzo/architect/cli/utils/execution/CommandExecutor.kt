package io.github.alemazzo.architect.cli.utils.execution


interface CommandExecutor {
	fun execute(command: String, workingDir: String? = null): Boolean
}


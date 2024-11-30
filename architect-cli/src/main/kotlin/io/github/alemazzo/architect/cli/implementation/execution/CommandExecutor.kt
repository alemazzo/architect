package io.github.alemazzo.architect.cli.implementation.execution


interface CommandExecutor {
	fun execute(command: String, workingDir: String? = null): Boolean
}


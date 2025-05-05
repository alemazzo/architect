package io.github.alemazzo.architect.cli.engine.components.executor.api


interface CommandExecutor {
	fun execute(command: String, workingDir: String? = null)
	fun executeAsync(command: String, workingDir: String? = null): Process
}


package io.github.alemazzo.architect.cli.engine.utils.executor.api


interface CommandExecutor {
	fun execute(command: String, workingDir: String? = null)
}


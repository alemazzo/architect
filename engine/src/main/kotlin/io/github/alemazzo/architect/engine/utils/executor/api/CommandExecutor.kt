package io.github.alemazzo.architect.engine.utils.executor.api


interface CommandExecutor {
	fun execute(command: String, workingDir: String? = null)
}


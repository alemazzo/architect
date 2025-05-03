package io.github.alemazzo.architect.cli.mock

import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.micronaut.context.annotation.Primary
import jakarta.inject.Singleton

@Singleton
@Primary
class MockedCommandExecutor : CommandExecutor {

	private val logger = getLogger()

	override fun execute(command: String, workingDir: String?): Boolean {
		logger.info("Mocked phases execution: $command")
		return true
	}
}
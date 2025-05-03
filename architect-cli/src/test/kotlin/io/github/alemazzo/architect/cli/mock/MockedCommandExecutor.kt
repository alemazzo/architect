package io.github.alemazzo.architect.cli.mock

import io.github.alemazzo.architect.cli.api.log.WithLogger
import io.github.alemazzo.architect.cli.implementation.execution.CommandExecutor
import io.micronaut.context.annotation.Primary
import jakarta.inject.Singleton

@Singleton
@Primary
class MockedCommandExecutor : CommandExecutor, WithLogger {
	override fun execute(command: String, workingDir: String?): Boolean {
		logger.info("Mocked phases execution: $command")
		return true
	}
}
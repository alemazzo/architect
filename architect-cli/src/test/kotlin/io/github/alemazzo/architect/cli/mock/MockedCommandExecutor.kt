package io.github.alemazzo.architect.cli.mock

import io.github.alemazzo.architect.cli.utils.execution.CommandExecutor
import io.github.alemazzo.architect.cli.utils.log.WithLogger
import io.micronaut.context.annotation.Primary
import jakarta.inject.Singleton

@Singleton
@Primary
class MockedCommandExecutor : CommandExecutor, WithLogger {
	override fun execute(command: String, workingDir: String?): Boolean {
		logger.info("Mocked architect execution: $command")
		return true
	}
}
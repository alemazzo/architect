package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.tasks.InitializersRunner
import io.github.alemazzo.architect.cli.utils.CommandExecutor
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class InitializersRunnerTest(override val executor: CommandExecutor) : CommandIntegrationTest(), DisableExecutor {

	@Test
	fun `test usage`() {
		val output = execute(InitializersRunner::class.java)
		assert(output.contains("All initializers passed"))
	}

	@Test
	fun `test help`() {
		val output = execute(InitializersRunner::class.java, "--help")
		assert(output.contains("Usage: init [-hV]"))
	}

}


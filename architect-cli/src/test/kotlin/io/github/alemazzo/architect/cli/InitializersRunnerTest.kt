package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.InitializersRunner
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class InitializersRunnerTest : CommandIntegrationTest() {

	@Test
	fun `test usage`() {
		val output = execute(InitializersRunner::class.java)
		println(output)
		assert(output.contains("All initializers passed"))

	}

	@Test
	fun `test help`() {
		val output = execute(InitializersRunner::class.java, "--help")
		println(output)
		assert(output.contains("Usage: init [-hV]"))
	}

}


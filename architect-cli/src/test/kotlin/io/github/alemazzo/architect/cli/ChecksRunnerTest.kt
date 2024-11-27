package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.ChecksRunner
import org.junit.jupiter.api.Test

class ChecksRunnerTest : CommandIntegrationTest() {


	@Test
	fun `test usage`() {
		val output = execute(ChecksRunner::class.java)
		assert(output.contains("All checks passed"))
		println(output)
	}

	@Test
	fun `test help`() {
		val output = execute(ChecksRunner::class.java, "--help")
		assert(output.contains("Usage: check [-hV]"))
	}

}
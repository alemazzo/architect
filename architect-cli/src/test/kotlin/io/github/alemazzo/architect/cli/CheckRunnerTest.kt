package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.CheckRunner
import io.github.alemazzo.architect.cli.utils.CommandExecutor
import org.junit.jupiter.api.Test

class CheckRunnerTest(
	override val executor: CommandExecutor,
) : CommandIntegrationTest(), DisableExecutor {


	@Test
	fun `test usage`() {
		val output = execute(CheckRunner::class.java)
		assert(output.contains("All checks passed"))
		println(output)
	}

	@Test
	fun `test help`() {
		val output = execute(CheckRunner::class.java, "--help")
		assert(output.contains("Usage: check [-hV]"))
	}

}
package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.CommandIntegrationTest
import io.github.alemazzo.architect.cli.engine.tasks.application.executors.init.InitTasksCommand
import org.junit.jupiter.api.Test

class InitTasksCommand(
	private val initTasksExecutor: InitTasksCommand,
) : CommandIntegrationTest() {

	@Test
	fun `test usage`() {
		val output = execute(initTasksExecutor)
		println(output)
		assert(output.contains("Running tasks: init"))
	}

	@Test
	fun `test help`() {
		val output = execute(initTasksExecutor, "-h")
		println(output)
		assert(output.contains("Usage: init [-hV]"))
	}

}
package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.CommandIntegrationTest
import io.github.alemazzo.architect.cli.engine.components.tasks.application.executors.build.BuildTasksCommand
import org.junit.jupiter.api.Test

class BuildTasksCommand(
	private val buildTasksExecutor: BuildTasksCommand,
) : CommandIntegrationTest() {

	@Test
	fun `test usage`() {
		val output = execute(buildTasksExecutor)
		println(output)
		assert(output.contains("Running phase: build"))

	}

	@Test
	fun `test help`() {
		val output = execute(buildTasksExecutor, "-h")
		println(output)
		assert(output.contains("Usage: build [-hV]"))
	}

}


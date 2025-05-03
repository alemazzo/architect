package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.CommandIntegrationTest
import io.github.alemazzo.architect.cli.engine.components.phases.application.executors.init.InitPhaseExecutor
import org.junit.jupiter.api.Test

class InitPhaseExecutorTest(
	private val initPhaseExecutor: InitPhaseExecutor,
) : CommandIntegrationTest() {

	@Test
	fun `test usage`() {
		val output = execute(initPhaseExecutor)
		println(output)
		assert(output.contains("Running phase executor: init"))
	}

	@Test
	fun `test help`() {
		val output = execute(initPhaseExecutor, "-h")
		println(output)
		assert(output.contains("Usage: init [-hV]"))
	}

}
package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.CommandIntegrationTest
import io.github.alemazzo.architect.cli.engine.phases.build.BuildPhaseExecutor
import org.junit.jupiter.api.Test

class BuildPhaseExecutorTest(
	private val buildPhaseExecutor: BuildPhaseExecutor,
) : CommandIntegrationTest() {

	@Test
	fun `test usage`() {
		val output = execute(buildPhaseExecutor)
		println(output)
		assert(output.contains("Running phase executor: build"))

	}

	@Test
	fun `test help`() {
		val output = execute(buildPhaseExecutor, "-h")
		println(output)
		assert(output.contains("Usage: build [-hV]"))
	}

}


package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.plugins.architect.plugins.checks.ChecksPlugin
import org.junit.jupiter.api.Test

class ChecksPluginTest : CommandIntegrationTest() {


	@Test
	fun `test usage`() {
		val output = execute(ChecksPlugin::class.java)
		assert(output.contains("All checks passed"))
		println(output)
	}

	@Test
	fun `test help`() {
		val output = execute(ChecksPlugin::class.java, "--help")
		assert(output.contains("Usage: check [-hV]"))
	}

}
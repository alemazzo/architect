package io.github.alemazzo.architect.cli

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class ArchitectPluginTest : CommandIntegrationTest() {

	@Test
	fun `test usage`() {
		val output = execute(ArchitectPlugin::class.java)
		assert(output.contains("Usage: architect-cli [-hV] [COMMAND]"))
	}

	@Test
	fun `test help`() {
		val output = execute(ArchitectPlugin::class.java, "--help")
		assert(output.contains("Usage: architect-cli [-hV] [COMMAND]"))
	}

}


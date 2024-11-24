package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.InitCommand
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class InitCommandTest : CommandIntegrationTest() {

    @Test
    fun `test usage`() {
        val output = execute(InitCommand::class.java)
        assert(output.contains("All initializers passed"))
    }

    @Test
    fun `test help`() {
        val output = execute(InitCommand::class.java, "--help")
        assert(output.contains("Usage: init [-hV]"))
    }

}


package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.commands.CheckCommand
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test


class CheckCommandTest : CommandIntegrationTest() {

    @Test
    fun `test usage`() {
        val output = execute(CheckCommand::class.java)
        assert(output.contains("All checks passed"))
        println(output)
    }

    @Test
    fun `test help`() {
        val output = execute(CheckCommand::class.java, "--help")
        assert(output.contains("Usage: check [-hV]"))
    }

}
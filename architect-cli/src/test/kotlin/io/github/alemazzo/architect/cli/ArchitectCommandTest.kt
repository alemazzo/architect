package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.ArchitectCommand
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@MicronautTest
class ArchitectCommandTest {

    val ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    fun <T: Runnable> execute(clazz: Class<T>, vararg args: String): String {
        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos))
        PicocliRunner.run(clazz, ctx, *args)
        return baos.toString()
    }

    @AfterEach
    fun cleanup() {
        ctx.close()
    }

    @Test
    fun testWithCheck() {
        val output = execute(ArchitectCommand::class.java, "check")
        Assertions.assertTrue(output.contains("Hello from Check!"))
    }

    @Test
    fun testWithHelp() {
        val output = execute(ArchitectCommand::class.java, "help")
        Assertions.assertTrue(output.contains("Hello from Architect!"))
    }
}

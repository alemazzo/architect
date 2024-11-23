package io.github.alemazzo

import io.github.alemazzo.architect.ArchitectCommand
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@MicronautTest
class ArchitectCommandTest {

    @Test
    fun testWithCommandLineOption() {
        val ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos))

        val args = arrayOf("-v")
        PicocliRunner.run(ArchitectCommand::class.java, ctx, *args)

        Assertions.assertTrue(baos.toString().contains("Hello from Architect!"))

        ctx.close()
    }
}

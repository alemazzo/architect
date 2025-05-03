package io.github.alemazzo.architect.cli.api

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import picocli.CommandLine
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@MicronautTest
open class CommandIntegrationTest {

	fun execute(command: Any, vararg args: String): String {
		val baos = ByteArrayOutputStream()
		val sout = System.out
		System.setOut(PrintStream(baos))
		val commandLine = CommandLine(command)
		commandLine.execute(*args)
		System.setOut(sout)
		return baos.toString()
	}

}


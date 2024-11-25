package io.github.alemazzo.architect.cli

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@MicronautTest
open class CommandIntegrationTest {

	@Inject
	lateinit var ctx: ApplicationContext

	fun <T : Runnable> execute(clazz: Class<T>, vararg args: String): String {
		val baos = ByteArrayOutputStream()
		val sout = System.out
		System.setOut(PrintStream(baos))
		PicocliRunner.run(clazz, ctx, *args)
		System.setOut(sout)
		return baos.toString()
	}

}


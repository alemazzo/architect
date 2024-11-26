package io.github.alemazzo.architect.cli.context

import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import java.io.File

@Factory
class ContextFactory {

	@Singleton
	fun getExternalConfiguration(): Context {
		println("Loading context")
		val file = File("architect.yml")
		if (!file.exists()) {
			println("External context not found")
			return Context()
		}
		println("External context found")
		val context = Context(file.readText())
		println("External context loaded: $context")
		return context
	}

}
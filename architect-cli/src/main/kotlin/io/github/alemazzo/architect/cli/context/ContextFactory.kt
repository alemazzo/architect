package io.github.alemazzo.architect.cli.context

import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import java.io.File

@Factory
class ContextFactory {

	@Singleton
	fun getExternalConfiguration(): Context {
		println("Loading configuration")
		val file = File("architect.yml")
		if (!file.exists()) {
			println("External configuration not found")
			return Context()
		}
		println("External configuration found")
		val context = Context(file.readText())
		println("External configuration loaded: $context")
		return context
	}

}
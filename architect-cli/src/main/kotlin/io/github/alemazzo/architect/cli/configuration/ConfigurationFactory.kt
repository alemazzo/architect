package io.github.alemazzo.architect.cli.configuration

import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton
import java.io.File

@Factory
class ConfigurationFactory {

	@Singleton
	@Requires(resources = ["file:architect.yml"])
	fun getExternalConfiguration(): Context {
		println("Loading external configuration")
		val context = Context(File("architect.yml").readText())
		println("External configuration loaded: $context")
		return context
	}

}
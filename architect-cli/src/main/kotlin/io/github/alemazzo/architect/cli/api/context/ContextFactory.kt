package io.github.alemazzo.architect.cli.api.context

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import java.io.File

@Factory
class ContextFactory : Architect {

	@Singleton
	fun getExternalConfiguration(): Context {
		val file = File("architect.yml")
		if (!file.exists()) {
			logger.warn("No external configuration found")
			return Context()
		}
		return Context(file.readText())
	}

}
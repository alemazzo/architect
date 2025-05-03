package io.github.alemazzo.architect.cli.engine.applications.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import java.io.File

@Factory
class ContextFactory  {

	private val logger = getLogger()

	@Singleton
	fun getExternalConfiguration(): Context {
		val file = File("phases.yml")
		if (!file.exists()) {
			logger.warn("No external configuration found")
			return Context()
		}
		return Context(file.readText())
	}

}
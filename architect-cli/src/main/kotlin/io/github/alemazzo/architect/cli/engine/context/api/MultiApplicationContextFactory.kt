package io.github.alemazzo.architect.cli.engine.context.api

import io.github.alemazzo.architect.cli.engine.utils.log.getLogger
import io.micronaut.context.ApplicationContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
class MultiApplicationContextFactory(applicationContext: ApplicationContext) : CommandLine.IFactory {

	private val contexts = mutableSetOf<ApplicationContext>()
	private val logger = getLogger()

	init {
		contexts.add(applicationContext)
	}

	fun addContext(context: ApplicationContext) {
		contexts.add(context)
	}

	override fun <K : Any?> create(cls: Class<K>?): K {
		// Try in every context
		for (context in contexts) {
			try {
				val bean = context.getBean(cls)
				if (bean != null) {
					return bean
				}
			} catch (e: Exception) {
				logger.debug("Error while trying to get bean from context", e)
			}
		}
		return CommandLine.defaultFactory().create(cls)
	}
}
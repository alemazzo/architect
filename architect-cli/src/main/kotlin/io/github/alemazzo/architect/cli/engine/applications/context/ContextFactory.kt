package io.github.alemazzo.architect.cli.engine.applications.context

import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.github.alemazzo.architect.cli.engine.api.log.getLogger
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import java.io.File


@Factory
@Singleton
class ContextFactory {

	private val logger = getLogger()

	@Singleton
	fun getExternalConfiguration(): Context {
		val contextDir = File(".architect")

		if (!contextDir.exists() || !contextDir.isDirectory) {
			logger.info("No .architect directory found")
			return Context()
		}

		val yamlFiles = contextDir.listFiles { file ->
			file.isFile && (file.extension == "yaml" || file.extension == "yml")
		} ?: emptyArray()

		if (yamlFiles.isEmpty()) {
			logger.info("No YAML context files found in .architect")
			return Context()
		}

		val configuration = StringBuilder()
		yamlFiles.forEach { file ->
			try {
				logger.info("Found context file: ${file.name}")
				configuration.append(file.readText())
				configuration.append("\n")
			} catch (e: Exception) {
				logger.info("Failed to read file: ${file.name}, skipping. Reason: ${e.message}")
			}
		}

		return Context(configuration.toString())
	}
}

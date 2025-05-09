package io.github.alemazzo.architect.engine.context.application

import io.github.alemazzo.architect.engine.context.api.Context
import io.github.alemazzo.architect.engine.utils.log.getLogger
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import java.io.File

@Factory
@Singleton
class ContextFactory {

	private val logger = getLogger()

	@Singleton
	fun getExternalConfiguration(): Context {
		val configuration = StringBuilder()

		// 1) Load the main architect.yml/yaml if present
		val rootYaml = File("architect.yml").takeIf { it.exists() }
			?: File("architect.yaml").takeIf { it.exists() }
		if (rootYaml != null) {
			try {
				logger.info("Loading root configuration: ${rootYaml.name}")
				configuration.append(rootYaml.readText()).append("\n")
			} catch (e: Exception) {
				logger.warn("Failed to read ${rootYaml.name}, skipping. Reason: ${e.message}")
			}
		} else {
			logger.info("No root architect.yml/.yaml found")
		}

		// 2) Load all files in .architect folder
		val contextDir = File(".architect")
		if (!contextDir.exists() || !contextDir.isDirectory) {
			logger.info("No .architect directory found")
			return Context(configuration.toString())
		}

		val yamlFiles = contextDir.listFiles { file ->
			file.isFile && (file.extension.equals("yml", true) || file.extension.equals("yaml", true))
		}?.sortedBy { it.name }  // optional: deterministic order
			?: emptyList()

		if (yamlFiles.isEmpty()) {
			logger.info("No YAML context files found in .architect")
			return Context(configuration.toString())
		}

		yamlFiles.forEach { file ->
			try {
				logger.info("Merging context file: ${file.name}")
				configuration.append(file.readText()).append("\n")
			} catch (e: Exception) {
				logger.warn("Failed to read file: ${file.name}, skipping. Reason: ${e.message}")
			}
		}

		return Context(configuration.toString())
	}
}

package io.github.alemazzo.architect.cli.plugins.pipelines.application

import io.github.alemazzo.architect.cli.engine.api.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

@Singleton
@Command(name = "init")
class PipelinesInitCommand(
	private val pipelinesContextHolder: PipelinesContextHolder,
	private val resourceExtractor: ResourceExtractor,
) : Init {

	val resourceRoot = "plugins/pipelines/"
	val resourceFile = resourceRoot + pipelinesContextHolder.pipeline.type + ".yml"

	override fun run() {
		val pipelinesDir = File(".github/workflows")

		pipelinesDir.listFiles()
			?.filter { it.name.endsWith(".yml") }
			?.forEach { it.delete() }

		if (!pipelinesDir.exists()) {
			pipelinesDir.mkdirs()
		}

		resourceExtractor.getResourceFileContent(resourceFile)
			.let { content ->
				val filePath = File(pipelinesDir, "${pipelinesContextHolder.pipeline.name}.yml")
				filePath.writeText(content
					.replace("{{name}}", pipelinesContextHolder.pipeline.name)
				)
			}
	}

}
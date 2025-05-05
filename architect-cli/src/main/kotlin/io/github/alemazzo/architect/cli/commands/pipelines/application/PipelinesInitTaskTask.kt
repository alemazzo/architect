package io.github.alemazzo.architect.cli.commands.pipelines.application

import io.github.alemazzo.architect.cli.engine.components.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.tasks.api.init.InitTask
import io.github.alemazzo.architect.cli.plugins.pipelines.context.PipelinesContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.io.File

@Singleton
@Command(name = "init")
class PipelinesInitTaskTask(
	private val pipelinesContextHolder: PipelinesContextHolder,
	private val resourceExtractor: ResourceExtractor,
) : InitTask {

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
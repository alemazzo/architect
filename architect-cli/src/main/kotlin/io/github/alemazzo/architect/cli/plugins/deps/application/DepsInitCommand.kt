package io.github.alemazzo.architect.cli.plugins.deps.application

import io.github.alemazzo.architect.cli.engine.api.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import io.github.alemazzo.architect.cli.plugins.deps.context.DepsContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.io.File

@Singleton
@Command(name = "init")
class DepsInitCommand(
	private val depsContextHolder: DepsContextHolder,
	private val resourceExtractor: ResourceExtractor,
) : Init {

	val resourceRoot = "plugins/deps/" + depsContextHolder.deps.type
	val resourceFile = resourceRoot + "/${depsContextHolder.deps.type}.${depsContextHolder.deps.format}"

	override fun run() {
		val depsDir = File(".github/")
		println("Creating deps file in $depsDir")
		resourceExtractor.getResourceFileContent(resourceFile)
			.let { content ->
				val filePath = File(depsDir, "${depsContextHolder.deps.type}.${depsContextHolder.deps.format}")
				filePath.writeText(content)
			}
	}

}
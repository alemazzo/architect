package io.github.alemazzo.architect.cli.plugins.deps.application

import io.github.alemazzo.architect.cli.engine.components.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.tasks.api.init.InitTask
import io.github.alemazzo.architect.cli.plugins.deps.context.DepsContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.io.File

@Singleton
@Command(name = "init")
class DepsInitTaskTask(
	depsContextHolder: DepsContextHolder,
	private val resourceExtractor: ResourceExtractor,
) : InitTask {

	val resourceRoot = "plugins/deps/" + depsContextHolder.deps.type

	override fun run() {
		val depsDir = File(".github/")
		println("Creating deps file in $depsDir")
		resourceExtractor.copyDirectoryFromResources(resourceRoot, depsDir.toPath())
	}

}
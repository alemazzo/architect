package io.github.alemazzo.architect.core.dependencies.application

import io.github.alemazzo.architect.engine.utils.resources.ResourceExtractor
import io.github.alemazzo.architect.engine.tasks.api.init.InitTask
import io.github.alemazzo.architect.core.dependencies.context.DependenciesContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.io.File

@Singleton
@Command(name = "init")
class DependenciesInitTask(
	dependenciesContext: DependenciesContext,
	private val resourceExtractor: ResourceExtractor,
) : InitTask {

	val resourceRoot = "plugins/deps/" + dependenciesContext.deps.type

	override fun run() {
		val depsDir = File(".github/")
		println("Creating deps file in $depsDir")
		resourceExtractor.copyDirectoryFromResources(resourceRoot, depsDir.toPath())
	}

}
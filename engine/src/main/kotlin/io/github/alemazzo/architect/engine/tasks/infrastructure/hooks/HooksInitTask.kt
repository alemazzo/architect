package io.github.alemazzo.architect.engine.tasks.infrastructure.hooks

import io.github.alemazzo.architect.engine.utils.resources.ResourceExtractor
import io.github.alemazzo.architect.engine.utils.executor.api.CommandExecutor
import io.github.alemazzo.architect.engine.tasks.api.init.InitTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.Paths

@Singleton
@Command(name = "init")
class HooksInitTask(
	private val resourceExtractor: ResourceExtractor,
	private val commandExecutor: CommandExecutor
) : InitTask {

	val resourceRoot = "hooks"

	override fun run() {
		val hooksDir = Paths.get(".git/hooks")
		resourceExtractor.copyDirectoryFromResources(resourceRoot, hooksDir)
		resourceExtractor.listResourceFiles(resourceRoot).forEach { file ->
			val fileName = file.substringAfterLast("/")
			commandExecutor.execute("chmod +x $hooksDir/$fileName")
		}
	}

}
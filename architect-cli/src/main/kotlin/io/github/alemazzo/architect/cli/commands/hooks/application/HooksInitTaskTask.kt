package io.github.alemazzo.architect.cli.commands.hooks.application

import io.github.alemazzo.architect.cli.engine.components.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.tasks.api.init.InitTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.Paths

@Singleton
@Command(name = "init")
class HooksInitTaskTask(
	private val resourceExtractor: ResourceExtractor,
	private val commandExecutor: CommandExecutor
) : InitTask {

	val resourceRoot = "plugins/hooks"

	override fun run() {
		val hooksDir = Paths.get(".git/hooks")
		resourceExtractor.copyDirectoryFromResources(resourceRoot, hooksDir)
		resourceExtractor.listResourceFiles(resourceRoot).forEach { file ->
			val fileName = file.substringAfterLast("/")
			commandExecutor.execute("chmod +x $hooksDir/$fileName")
		}
	}

}
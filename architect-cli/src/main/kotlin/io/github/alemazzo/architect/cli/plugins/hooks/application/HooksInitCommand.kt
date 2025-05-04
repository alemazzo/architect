package io.github.alemazzo.architect.cli.plugins.hooks.application

import io.github.alemazzo.architect.cli.engine.api.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.net.JarURLConnection
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Singleton
@Command(name = "init")
class HooksInitCommand(
	private val resourceExtractor: ResourceExtractor,
	private val commandExecutor: CommandExecutor
) : Init {

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
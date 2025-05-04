package io.github.alemazzo.architect.cli.plugins.installers.application

import io.github.alemazzo.architect.cli.engine.api.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import io.github.alemazzo.architect.cli.plugins.installers.context.InstallersContextHolder
import jakarta.inject.Singleton
import picocli.CommandLine
import java.io.File
import java.nio.file.Paths

@Singleton
@CommandLine.Command(name = "init")
class InstallerInitTask(
	private val installersContextHolder: InstallersContextHolder,
	private val resourceExtractor: ResourceExtractor,
	private val commandExecutor: CommandExecutor
) : Init {

	val resourceRoot = "plugins/installers"

	override fun run() {
		val context = installersContextHolder.installers ?: return

		val installersDir = Paths.get(context.path)
		resourceExtractor.copyDirectoryFromResources(resourceRoot, installersDir)
		File(installersDir.toString()).listFiles()?.forEach { file ->
			val content = file.readText()
			val replacedContent = content
				.replace("{{owner}}", context.owner)
				.replace("{{name}}", context.name)
				.replace("{{assetType}}", context.assetType)
				.replace("{{appPath}}", context.appPath)
			file.writeText(replacedContent)
			commandExecutor.execute("chmod +x ${file.path}")
		}
	}


}
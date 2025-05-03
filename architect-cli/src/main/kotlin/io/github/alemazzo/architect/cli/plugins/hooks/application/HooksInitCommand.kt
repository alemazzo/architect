package io.github.alemazzo.architect.cli.plugins.hooks.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.net.JarURLConnection
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Singleton
@Command(name = "init")
class HooksInitCommand : Init {

	val resourceRoot = "plugins/hooks"

	override fun run() {
		val hooksDir = Paths.get(".git/hooks")
		if (!Files.exists(hooksDir)) {
			Files.createDirectories(hooksDir)
		}

		val classLoader = Thread.currentThread().contextClassLoader
		val resourceUrl = classLoader.getResource(resourceRoot)
			?: throw IllegalStateException("Resource path $resourceRoot not found")

		if (resourceUrl.protocol == "jar") {
			val connection = resourceUrl.openConnection() as JarURLConnection
			val jarFile = connection.jarFile
			val entries = jarFile.entries()

			while (entries.hasMoreElements()) {
				val entry = entries.nextElement()
				if (entry.name.startsWith(resourceRoot) && !entry.isDirectory) {
					val relativePath = entry.name.removePrefix("$resourceRoot/") // Only the file name
					val targetPath = hooksDir.resolve(relativePath)

					classLoader.getResourceAsStream(entry.name)?.use { input ->
						Files.copy(input, targetPath, StandardCopyOption.REPLACE_EXISTING)
						targetPath.toFile().setExecutable(true)
					}
				}
			}
		} else {
			val path = Paths.get(resourceUrl.toURI())
			Files.walk(path).filter { Files.isRegularFile(it) }.forEach { file ->
				val relative = path.relativize(file)
				val target = hooksDir.resolve(relative.toString())
				Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING)
				target.toFile().setExecutable(true)
			}
		}
	}

}
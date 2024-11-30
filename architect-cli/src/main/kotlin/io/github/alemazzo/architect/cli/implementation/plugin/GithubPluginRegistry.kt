package io.github.alemazzo.architect.cli.implementation.plugin

import io.github.alemazzo.architect.cli.api.log.WithLogger
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.implementation.execution.CommandExecutor
import jakarta.inject.Singleton
import java.io.File
import java.net.URLClassLoader

@Singleton
class GithubPluginRegistry(
	private val configuration: PluginsConfiguration,
	private val commandExecutor: CommandExecutor,
) : WithLogger {

	fun getAll(): List<Plugin<*>> {
		return configuration.plugins.mapNotNull { loadPlugins(it) }
	}

	private fun loadPlugins(plugin: GithubPluginConfiguration): Plugin<*>? {
		val owner = plugin.owner
		val repo = plugin.name
		val tempFolder = ".architect/tmp"
		val repoFolder = "$tempFolder/$repo"

		try {

			// Create a temporary directory to store the plugin
			commandExecutor.execute("mkdir -p $tempFolder")

			// Create a directory for the plugin
			commandExecutor.execute("mkdir -p $repoFolder")

			// Download the Jar with CURL and save it in a temporary directory
			commandExecutor.execute(
				"curl -LJO https://github.com/"
						+ owner + "/" + repo + "/releases/latest/download/"
						+ repo + ".jar -o " + repoFolder + "/" + repo + ".jar"
			)

			// Load the plugin from the Jar
			val loadedCommand = loadCommandFromJar(File("$repoFolder/$repo.jar"), plugin.loadClass)

			// Clean up the repository folder
			commandExecutor.execute("rm -rf $repoFolder")

			// Clean up the temporary folder if it's empty
			commandExecutor.execute("rmdir $tempFolder")

			return object : Plugin<Runnable>(plugin.name) {
				override val context: Runnable
					get() = TODO("Not yet implemented")

				override fun run() {
					loadedCommand.run()
				}
			}
		} catch (e: Exception) {
			logger.warn("Error loading plugin $repo: ${e.message}")
			return null
		}
	}

	private fun loadCommandFromJar(jarFile: File, loadClass: String): Runnable {
		val classLoader = URLClassLoader(arrayOf(jarFile.toURI().toURL()), this::class.java.classLoader)
		val commandClass = classLoader.loadClass(loadClass)
		return commandClass.getDeclaredConstructor().newInstance() as Runnable
	}

}
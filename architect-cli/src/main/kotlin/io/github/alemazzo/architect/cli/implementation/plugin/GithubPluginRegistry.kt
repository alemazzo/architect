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
		return configuration.plugins.map { loadPlugins(it) }
	}

	private fun loadPlugins(plugin: GithubPluginConfiguration): Plugin<*> {
		val owner = plugin.owner
		val repo = plugin.repo
		val tempFolder = ".architect/tmp"
		val repoFolder = "$tempFolder/$repo"

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
		return loadPluginFromJar(File("$repoFolder/$repo.jar"), plugin.loadClass)
	}

	private fun loadPluginFromJar(jarFile: File, loadClass: String): Plugin<*> {
		val classLoader = URLClassLoader(arrayOf(jarFile.toURI().toURL()), this::class.java.classLoader)
		val pluginClass = classLoader.loadClass(loadClass)
		return pluginClass.getDeclaredConstructor().newInstance() as Plugin<*>
	}

}
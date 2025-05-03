package io.github.alemazzo.architect.cli.plugins.plugins.registries.github

import io.github.alemazzo.architect.cli.api.log.WithLogger
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.context.MultiContextFactory
import io.github.alemazzo.architect.cli.implementation.execution.CommandExecutor
import io.github.alemazzo.architect.cli.plugins.plugins.context.PluginsContext
import io.micronaut.context.ApplicationContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import java.io.File
import java.net.URLClassLoader
import java.util.function.BiConsumer

@Singleton
class GithubPluginRegistry(
	private val configuration: PluginsContext,
	private val commandExecutor: CommandExecutor,
	private val multiContextFactory: MultiContextFactory,
	private val applicationContext: ApplicationContext,
) : WithLogger {

	fun getAll(): List<Plugin<*>> {
		return configuration.plugins.mapNotNull { loadPlugins(it) }
	}

	@Command
	class PluginCommand(
		name: String,
		private val applicationContext: ApplicationContext,
		private val command: BiConsumer<ApplicationContext?, List<String>>,
	) :
		Plugin<Void>(name) {
		override val context: Void? = null

		@Parameters
		var args: List<String> = emptyList()

		override fun run() {
			logger.info("Running Plugin: $name with args: $args")
			command.accept(applicationContext, args)
		}
	}

	private fun loadPlugins(plugin: GithubPluginConfiguration): Plugin<*>? {
		val owner = plugin.owner
		val name = plugin.name
		val tempFolder = ".phases/tmp"
		val repoFolder = "$tempFolder/$name"

		try {

			// Create a temporary directory to store the plugin
			commandExecutor.execute("mkdir -p $tempFolder")

			// Create a directory for the plugin
			commandExecutor.execute("mkdir -p $repoFolder")

			// Download the Jar with CURL and save it in a temporary directory
			val githubTokenFromEnvironment = System.getenv("GITHUB_TOKEN")
			commandExecutor.execute(
				"curl -H \"Authorization: token $githubTokenFromEnvironment\" -L  " +
						"https://github.com/$owner/$name/releases/latest/download/$name.jar -o $repoFolder/$name.jar"
			)

			// Log jar file size
			val jarFile = File("$repoFolder/$name.jar")
			logger.info("Jar file size: ${jarFile.length()} bytes")

			// Load the plugin from the Jar
			val (loadedCommand, applicationContext) = loadCommandFromJar(
				File("$repoFolder/$name.jar"),
				plugin.loadClass
			)

			// Clean up the repository folder
			// commandExecutor.execute("rm -rf $repoFolder")

			// Clean up the temporary folder if it's empty
			// commandExecutor.execute("rmdir $tempFolder")

			return PluginCommand(plugin.name, applicationContext, loadedCommand)
		} catch (e: Exception) {
			e.printStackTrace()
			logger.warn("Error loading plugin $name: ${e.message}")
			return null
		}
	}

	private fun loadCommandFromJar(
		jarFile: File,
		loadClass: String,
	): Pair<BiConsumer<ApplicationContext?, List<String>>, ApplicationContext> {
		logger.info("Loading plugin from jar: $jarFile")
		val classLoader = URLClassLoader(arrayOf(jarFile.toURI().toURL()), applicationContext.classLoader)
		return try {
			logger.info("Creating plugin context")
			val pluginContext = ApplicationContext.builder()
				.classLoader(classLoader)
				.start()
			multiContextFactory.addContext(pluginContext)
			logger.info("Extracting bean from plugin context")
			pluginContext.getBean(classLoader.loadClass(loadClass)) as BiConsumer<ApplicationContext?, List<String>> to pluginContext
		} catch (e: Exception) {
			throw e
		}
	}

}


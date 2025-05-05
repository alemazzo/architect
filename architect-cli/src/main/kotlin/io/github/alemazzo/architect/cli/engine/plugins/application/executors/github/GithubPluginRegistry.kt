package io.github.alemazzo.architect.cli.engine.plugins.application.executors.github

import io.github.alemazzo.architect.cli.engine.context.api.MultiApplicationContextFactory
import io.github.alemazzo.architect.cli.engine.utils.log.getLogger
import io.github.alemazzo.architect.cli.engine.utils.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.cli.engine.plugins.application.context.PluginsContext
import io.micronaut.context.ApplicationContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import java.io.File
import java.net.URLClassLoader
import java.util.function.BiConsumer

@Suppress("UNCHECKED_CAST")
@Singleton
class GithubPluginRegistry(
	private val configuration: PluginsContext,
	private val commandExecutor: CommandExecutor,
	private val multiContextFactory: MultiApplicationContextFactory,
	private val applicationContext: ApplicationContext,
) {

	private val logger = getLogger()

	fun getAll(): List<PluginCommand<*>> {
		return configuration.plugins.mapNotNull { loadPlugins(it) }
	}

	@Command
	class PluginCommandRunnable(
		name: String,
		private val applicationContext: ApplicationContext,
		private val command: BiConsumer<ApplicationContext?, List<String>>,
	) :
		PluginCommand<Void>(name) {
		private val logger = getLogger()

		@Parameters
		var args: List<String> = emptyList()

		override fun run() {
			logger.info("Running Plugin: $name with args: $args")
			command.accept(applicationContext, args)
		}
	}

	private fun loadPlugins(plugin: GithubPluginConfiguration): PluginCommand<*>? {
		val owner = plugin.owner
		val name = plugin.name
		val tempFolder = ".phases/tmp"
		val repoFolder = "$tempFolder/$name"

		try {

			// Create a temporary directory to store the plugins
			commandExecutor.execute("mkdir -p $tempFolder")

			// Create a directory for the plugins
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

			// Load the plugins from the Jar
			val (loadedCommand, applicationContext) = loadCommandFromJar(
				File("$repoFolder/$name.jar"),
				plugin.loadClass
			)

			// Clean up the repository folder
			// commandExecutor.execute("rm -rf $repoFolder")

			// Clean up the temporary folder if it's empty
			// commandExecutor.execute("rmdir $tempFolder")

			return PluginCommandRunnable(plugin.name, applicationContext, loadedCommand)
		} catch (e: Exception) {
			e.printStackTrace()
			logger.warn("Error loading plugins $name: ${e.message}")
			return null
		}
	}

	private fun loadCommandFromJar(
		jarFile: File,
		loadClass: String,
	): Pair<BiConsumer<ApplicationContext?, List<String>>, ApplicationContext> {
		logger.info("Loading plugins from jar: $jarFile")
		val classLoader = URLClassLoader(arrayOf(jarFile.toURI().toURL()), applicationContext.classLoader)
		return try {
			logger.info("Creating plugins context")
			val pluginContext = ApplicationContext.builder()
				.classLoader(classLoader)
				.start()
			multiContextFactory.addContext(pluginContext)
			logger.info("Extracting bean from plugins context")
			pluginContext.getBean(classLoader.loadClass(loadClass)) as BiConsumer<ApplicationContext?, List<String>> to pluginContext
		} catch (e: Exception) {
			throw e
		}
	}

}


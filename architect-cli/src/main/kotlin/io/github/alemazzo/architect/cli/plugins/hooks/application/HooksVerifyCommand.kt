package io.github.alemazzo.architect.cli.plugins.hooks.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths

@Singleton
@Command(name = "verify")
class HooksVerifyCommand : Verify {

	override fun run() {
		val hooksDir = Paths.get(".git/hooks")
		if (!Files.exists(hooksDir)) {
			println("❌ .git/hooks directory does not exist.")
			return
		}

		val resourceRoot = "plugins/hooks"
		val classLoader = Thread.currentThread().contextClassLoader

		val resourceUrl = classLoader.getResource(resourceRoot)
		if (resourceUrl == null) {
			println("❌ Could not find resources under $resourceRoot")
			return
		}

		val expectedHooks: List<String> = when (resourceUrl.protocol) {
			"file" -> {
				// Running from source
				Files.list(Paths.get(resourceUrl.toURI()))
					.map { it.fileName.toString() }
					.toList()
			}
			"jar" -> {
				// Running from a packaged JAR
				val jarPath = (resourceUrl.path.substringBefore("!")).removePrefix("file:")
				val jarFile = FileSystems.newFileSystem(Paths.get(jarPath), null as ClassLoader?)
				Files.walk(jarFile.getPath("/$resourceRoot"))
					.filter { Files.isRegularFile(it) }
					.map { it.fileName.toString() }
					.toList()
			}
			else -> {
				println("❌ Unsupported resource protocol: ${resourceUrl.protocol}")
				return
			}
		}

		var allPresent = true

		for (hook in expectedHooks) {
			val hookPath = hooksDir.resolve(hook)
			if (!Files.exists(hookPath)) {
				println("❌ Missing hook: $hook")
				allPresent = false
			} else if (!Files.isExecutable(hookPath)) {
				println("⚠️ Hook exists but is not executable: $hook")
				allPresent = false
			} else {
				println("✅ Hook present and executable: $hook")
			}
		}

		if (allPresent) {
			println("✅ All expected Git hooks are properly installed.")
		} else {
			println("⚠️ Some Git hooks are missing or not executable.")
		}
	}


}
package io.github.alemazzo.architect.cli.plugins.commits.application

import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.Files
import java.io.File
import java.io.InputStream
import java.net.JarURLConnection
import java.nio.file.*
import java.util.jar.JarFile

@Singleton
@Command(name = "init")
class InitCommitsCommand(
	val context: CommitsContext,
	val executor: CommandExecutor
) : Init {
	override fun run() {
		println("Initializing commits")
	}

}
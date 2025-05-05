package io.github.alemazzo.architect.cli.commands.scripts.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.init.InitTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class ScriptsInitTaskTask : InitTask {

	override fun run() {
		println("Executing scripts install")
	}

}
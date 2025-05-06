package io.github.alemazzo.architect.core.scripts.application

import io.github.alemazzo.architect.engine.tasks.api.init.InitTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class ScriptsInitTask : InitTask {

	override fun run() {
		println("Executing scripts install")
	}

}
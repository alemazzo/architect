package io.github.alemazzo.architect.cli.plugins.scripts.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class ScriptsInitTask : Init {

	override fun run() {
		println("Executing scripts install")
	}

}
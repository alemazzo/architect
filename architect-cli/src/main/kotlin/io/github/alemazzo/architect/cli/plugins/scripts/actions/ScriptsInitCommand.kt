package io.github.alemazzo.architect.cli.plugins.scripts.actions

import io.github.alemazzo.architect.cli.api.phases.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class ScriptsInitCommand : Init {

	override fun run() {
		println("Executing scripts install")
	}

}
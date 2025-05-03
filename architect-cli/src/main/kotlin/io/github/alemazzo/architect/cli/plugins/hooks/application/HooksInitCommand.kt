package io.github.alemazzo.architect.cli.plugins.hooks.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class HooksInitCommand : Init {

	override fun run() {
		println("Executing hooks install")
	}

}
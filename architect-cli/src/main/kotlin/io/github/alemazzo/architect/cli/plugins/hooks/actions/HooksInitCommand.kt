package io.github.alemazzo.architect.cli.plugins.hooks.actions

import io.github.alemazzo.architect.cli.api.phases.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "install")
class HooksInitCommand : Init {

	override fun run() {
		println("Executing hooks install")
	}

}
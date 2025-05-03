package io.github.alemazzo.architect.cli.plugins.scripts.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class ScriptsVerifyCommand : Verify {

	override fun run() {
		println("Executing scripts verify")
	}

}
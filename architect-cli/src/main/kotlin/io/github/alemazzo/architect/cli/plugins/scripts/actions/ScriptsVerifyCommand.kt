package io.github.alemazzo.architect.cli.plugins.scripts.actions

import io.github.alemazzo.architect.cli.api.phases.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class ScriptsVerifyCommand : Verify {

	override fun run() {
		println("Executing scripts verify")
	}

}
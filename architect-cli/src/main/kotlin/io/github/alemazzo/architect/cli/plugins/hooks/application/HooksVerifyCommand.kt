package io.github.alemazzo.architect.cli.plugins.hooks.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class HooksVerifyCommand : Verify {

	override fun run() {
		println("Executing hooks verify")
	}

}
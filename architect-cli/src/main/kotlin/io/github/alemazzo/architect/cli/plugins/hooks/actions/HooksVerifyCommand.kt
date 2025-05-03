package io.github.alemazzo.architect.cli.plugins.hooks.actions

import io.github.alemazzo.architect.cli.api.phases.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class HooksVerifyCommand : Verify {

	override fun run() {
		println("Executing hooks verify")
	}

}
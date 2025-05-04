package io.github.alemazzo.architect.cli.plugins.deps.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class DepsVerifyTask : Verify {

	override fun run() {
		println("Verifying deps...")
	}

}
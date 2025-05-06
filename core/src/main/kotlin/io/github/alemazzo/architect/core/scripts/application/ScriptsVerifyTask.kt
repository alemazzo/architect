package io.github.alemazzo.architect.core.scripts.application

import io.github.alemazzo.architect.engine.tasks.api.verify.VerifyTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class ScriptsVerifyTask : VerifyTask {

	override fun run() {
		println("Executing scripts verify")
	}

}
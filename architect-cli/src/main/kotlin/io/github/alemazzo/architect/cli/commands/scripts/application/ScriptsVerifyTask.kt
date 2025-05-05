package io.github.alemazzo.architect.cli.commands.scripts.application

import io.github.alemazzo.architect.cli.engine.tasks.api.verify.VerifyTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class ScriptsVerifyTask : VerifyTask {

	override fun run() {
		println("Executing scripts verify")
	}

}
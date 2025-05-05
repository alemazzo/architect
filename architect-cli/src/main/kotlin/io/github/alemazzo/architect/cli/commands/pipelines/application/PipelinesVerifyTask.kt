package io.github.alemazzo.architect.cli.commands.pipelines.application

import io.github.alemazzo.architect.cli.engine.tasks.api.verify.VerifyTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class PipelinesVerifyTask : VerifyTask {

	override fun run() {
		println("Verifying pipelines...")
	}

}
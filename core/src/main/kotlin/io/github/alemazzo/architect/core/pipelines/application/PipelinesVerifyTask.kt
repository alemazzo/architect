package io.github.alemazzo.architect.core.pipelines.application

import io.github.alemazzo.architect.engine.tasks.api.verify.VerifyTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "verify")
class PipelinesVerifyTask : VerifyTask {

	override fun run() {
		println("Verifying pipelines...")
	}

}
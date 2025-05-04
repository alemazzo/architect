package io.github.alemazzo.architect.cli.plugins.pipelines.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.verify.Verify
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths

@Singleton
@Command(name = "verify")
class PipelinesVerifyCommand : Verify {

	override fun run() {
		println("Verifying pipelines...")
	}

}
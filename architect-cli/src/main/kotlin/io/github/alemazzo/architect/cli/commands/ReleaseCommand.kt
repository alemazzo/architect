package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.release.Releaser
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "release",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class ReleaseCommand(private val releaser: List<Releaser>) : Runnable {

	override fun run() {
		println("Hello from Release!")
		releaser.forEach(Releaser::run)
		println("All releasers executed")
	}

}
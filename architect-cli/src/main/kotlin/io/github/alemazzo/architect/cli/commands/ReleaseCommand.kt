package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.release.Releaser
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Command(
    name = "release",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class ReleaseCommand(@Inject private val releaser: List<Releaser>) : Runnable {

    override fun run() {
        println("Hello from Release!")
        releaser.forEach(Releaser::run)
        println("All releasers executed")
    }

}
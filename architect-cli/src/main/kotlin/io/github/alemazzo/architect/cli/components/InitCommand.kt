package io.github.alemazzo.architect.cli.components

import io.github.alemazzo.architect.cli.api.init.Initializer
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Command(
    name = "init",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class InitCommand(@Inject private val initializers: List<Initializer>) : Runnable {

    override fun run() {
        initializers.forEach(Initializer::run)
        println("All initializers passed")
    }

}


package io.github.alemazzo.architect

import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(
    name = "architect",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class ArchitectCommand : Runnable {

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose: Boolean = false

    override fun run() {
        // business logic here
        if (verbose) {
            println("Hi!")
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(ArchitectCommand::class.java, *args)
        }
    }
}

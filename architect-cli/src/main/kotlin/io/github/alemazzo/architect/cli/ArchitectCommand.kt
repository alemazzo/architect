package io.github.alemazzo.architect.cli

import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters

@Command(
    name = "check",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class CheckCommand : Runnable {
    override fun run() {
        // business logic here
        println("Hello from Check!")
    }
}

public enum class ArchCommand {
    check,
    help
}


@Command(
    name = "architect",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class ArchitectCommand : Runnable {

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose: Boolean = false

    @Parameters(index = "0", description = ["The command to execute"])
    private var command: ArchCommand = ArchCommand.help

    override fun run() {
        when (command) {
            ArchCommand.help -> {
                println("Hello from Architect!")
            }
            ArchCommand.check -> {
                PicocliRunner.run(CheckCommand::class.java)
            }
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(ArchitectCommand::class.java, *args)
        }
    }
}

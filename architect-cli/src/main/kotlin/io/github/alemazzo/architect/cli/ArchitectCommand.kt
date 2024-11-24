package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.components.CheckCommand
import io.github.alemazzo.architect.cli.components.InitCommand
import io.github.alemazzo.architect.cli.components.ProjectCommand
import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine
import picocli.CommandLine.Command

@Command(
    name = "architect-cli",
    description = ["..."],
    mixinStandardHelpOptions = true,
    subcommands = [ProjectCommand::class, InitCommand::class, CheckCommand::class]
)
class ArchitectCommand : Runnable {

    override fun run() {
        CommandLine.usage(this, System.out)
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(ArchitectCommand::class.java, *args)
        }
    }
}

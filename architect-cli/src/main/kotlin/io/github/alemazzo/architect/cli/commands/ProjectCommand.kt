package io.github.alemazzo.architect.cli.commands

import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(
    name = "project",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class ProjectCommand : Runnable {

    @Option(names = ["-n", "--name"], description = ["The name of the project"])
    var name: String? = null

    override fun run() {
        // business logic here
        println("Hello from Project! $name")
    }
}
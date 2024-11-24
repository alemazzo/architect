package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.annotation.Component
import io.github.alemazzo.architect.cli.api.check.Check
import jakarta.inject.Inject
import picocli.CommandLine.Command

@Component
@Command(
    name = "check",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class CheckCommand(
    @Inject
    val checks: List<Check>
) : Runnable {

    override fun run() {
        checks.forEach(Check::run)
        println("All checks passed")
    }
}


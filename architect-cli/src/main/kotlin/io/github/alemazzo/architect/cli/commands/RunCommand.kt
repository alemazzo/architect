package io.github.alemazzo.architect.cli.commands

import io.github.alemazzo.architect.cli.api.run.Runner
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Command(
    name = "run",
    description = ["Run the application"]
)
class RunCommand(private val runners: List<Runner>): Runnable {

    @Parameters(
        description = ["The name of the runner to execute"],
        defaultValue = ""
    )
    private var runnerName: String = ""

    override fun run() {
        if (runnerName.isNotEmpty()) {
            val runner = runners.find { it.name == runnerName }
            if (runner != null) {
                runner.run()
                println("Runner $runnerName executed")
            } else {
                println("Runner $runnerName not found")
            }
        }
    }

}

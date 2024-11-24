package io.github.alemazzo.architect.cli.setup.gradle

import io.github.alemazzo.architect.cli.api.annotation.Component

@Component
class GradleExecutor(private val configuration: GradleExecutorConfiguration) {

    private fun getCommand(args: Array<String>): String {
        return "${configuration.command} ${args.joinToString(" ")}"
    }

    fun execute(args: Array<String>): Boolean {
        if (configuration.mock) {
            println("Mocking Gradle execution")
            return true
        }
        println("Executing Gradle command: ${getCommand(args)}")
        val process = Runtime.getRuntime().exec(getCommand(args))
        val exitCode = process.waitFor()
        return exitCode == 0
    }
}
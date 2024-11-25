package io.github.alemazzo.architect.cli.setup.gradle

import io.github.alemazzo.architect.cli.api.annotation.Component

@Component
class GradleExecutor(private val configuration: GradleExecutorConfiguration) {

    private fun getCommand(args: Array<String>): String {
        return "${configuration.command} ${args.joinToString(" ")}"
    }

    fun execute(args: Array<String>): Boolean {
        val process = Runtime.getRuntime().exec(getCommand(args))
        val exitCode = process.waitFor()
        return exitCode == 0
    }
}
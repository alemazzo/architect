package io.github.alemazzo.architect.cli.setup.gradle.api

open class GradleTask(val gradleExecutor: GradleExecutor, val args: Array<String>): Runnable {
    override fun run() {
        println("Executing Gradle task with args: ${args.joinToString(" ")}")
        gradleExecutor.execute(args)
    }
}

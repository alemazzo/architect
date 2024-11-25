package io.github.alemazzo.architect.cli.setup.gradle.api

open class GradleTask(private val gradleExecutor: GradleExecutor, private val args: Array<String>) : Runnable {
	override fun run() {
		println("Executing Gradle task with args: ${args.joinToString(" ")}")
		gradleExecutor.execute(args)
	}
}

package io.github.alemazzo.architect.cli.setup.gradle.checks

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.setup.gradle.GradleExecutor

@Plugin
class GradleTestCommand(private val gradleExecutor: GradleExecutor) : Check {
    override fun check(): Boolean {
        println("Checking if the project can be tested with Gradle")
        return gradleExecutor.execute(arrayOf("test"))
    }
}
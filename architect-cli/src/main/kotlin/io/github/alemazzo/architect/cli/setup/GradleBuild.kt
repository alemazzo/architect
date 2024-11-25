package io.github.alemazzo.architect.cli.setup

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.setup.gradle.GradleExecutor

@Plugin
class GradleBuild(private val gradleExecutor: GradleExecutor) : Check {
    override fun check(): Boolean {
        println("Checking if the project can be built with Gradle")
        return gradleExecutor.execute(arrayOf("build"))
    }
}


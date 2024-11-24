package io.github.alemazzo.architect.cli.setup.gradle.checks

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.api.init.Initializer
import io.github.alemazzo.architect.cli.setup.gradle.GradleExecutor
import io.micronaut.context.annotation.Requires

@Plugin
@Requires(property = "architect.gradle.enabled", value = "true", defaultValue = "true")
class GradleBuild(private val gradleExecutor: GradleExecutor) : Check, Initializer {
    override fun check(): Boolean {
        println("Checking if the project can be built with Gradle")
        return gradleExecutor.execute(arrayOf("build"))
    }

    override fun init(): Boolean {
        return check()
    }
}


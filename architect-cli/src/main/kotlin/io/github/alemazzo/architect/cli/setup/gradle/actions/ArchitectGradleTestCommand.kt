package io.github.alemazzo.architect.cli.setup.gradle.actions

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.setup.gradle.api.GradleExecutor
import io.github.alemazzo.architect.cli.setup.gradle.api.GradleTask
import io.github.alemazzo.architect.cli.setup.gradle.api.RequiresGradle
import io.micronaut.context.annotation.Requires

@Plugin
@RequiresGradle
class ArchitectGradleTestCommand(gradleExecutor: GradleExecutor) : Check, GradleTask(gradleExecutor) {
    override fun run() {
        println("Checking if the project can be tested with Gradle")
        gradleExecutor.execute(arrayOf("test"))
    }
}
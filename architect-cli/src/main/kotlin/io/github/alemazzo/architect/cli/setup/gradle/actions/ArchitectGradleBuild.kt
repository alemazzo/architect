package io.github.alemazzo.architect.cli.setup.gradle.actions

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.api.init.Initializer
import io.github.alemazzo.architect.cli.setup.gradle.api.GradleExecutor
import io.github.alemazzo.architect.cli.setup.gradle.api.GradleTask
import io.github.alemazzo.architect.cli.setup.gradle.api.RequiresGradle

@Plugin
@RequiresGradle
class ArchitectGradleBuild(gradleExecutor: GradleExecutor) :
    Check, Initializer, GradleTask(gradleExecutor, arrayOf("build"))


package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.plugins.gradle.api.GradleExecutor
import io.github.alemazzo.architect.cli.plugins.gradle.api.GradleTask

@Architect
class ArchitectGradleBuild(gradleExecutor: GradleExecutor) :
	Check, Initializer, GradleTask(gradleExecutor, arrayOf("build"))


package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.plugins.gradle.api.GradleExecutor
import io.github.alemazzo.architect.cli.plugins.gradle.api.GradleTask

@Architect
class ArchitectGradleTestCommand(gradleExecutor: GradleExecutor) :
	Check, GradleTask(gradleExecutor, arrayOf("test"))
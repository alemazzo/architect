package io.github.alemazzo.architect.cli.setup.gradle.actions

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.check.Check
import io.github.alemazzo.architect.cli.setup.gradle.api.GradleExecutor
import io.github.alemazzo.architect.cli.setup.gradle.api.GradleTask
import io.github.alemazzo.architect.cli.setup.gradle.api.RequiresGradle

@Architect
@RequiresGradle
class ArchitectGradleTestCommand(gradleExecutor: GradleExecutor) :
	Check, GradleTask(gradleExecutor, arrayOf("test"))
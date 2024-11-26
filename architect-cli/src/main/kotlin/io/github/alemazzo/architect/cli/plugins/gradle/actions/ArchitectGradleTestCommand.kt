package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.plugins.gradle.GradlePlugin
import io.github.alemazzo.architect.cli.plugins.gradle.utils.GradleExecutor
import jakarta.inject.Singleton

@Singleton
@GradlePlugin
class ArchitectGradleTestCommand(val gradleExecutor: GradleExecutor) :
	Check {
	override fun run() {
		println("Executing Gradle task with args: test")
		gradleExecutor.execute(arrayOf("test"))
	}
}
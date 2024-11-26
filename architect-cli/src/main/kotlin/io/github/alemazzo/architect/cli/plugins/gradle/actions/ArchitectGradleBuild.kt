package io.github.alemazzo.architect.cli.plugins.gradle.actions

import io.github.alemazzo.architect.cli.api.command.check.Check
import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.plugins.gradle.GradlePlugin
import io.github.alemazzo.architect.cli.plugins.gradle.utils.GradleExecutor
import jakarta.inject.Singleton

@Singleton
@GradlePlugin
class ArchitectGradleBuild(val gradleExecutor: GradleExecutor) :
	Check, Initializer {

	override fun run() {
		println("Executing Gradle task with args: build")
		gradleExecutor.execute(arrayOf("build"))
	}
}
package io.github.alemazzo.architect.cli.plugins.gradle

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext

class Gradle : Plugin<GradleContext>(name) {
	companion object {
		const val name = "gradle"
	}

	@JsonProperty(Gradle.name)
	override var context: GradleContext? = null

}
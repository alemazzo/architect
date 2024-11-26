package io.github.alemazzo.architect.cli.plugins.gradle

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.configuration.Context
import io.github.alemazzo.architect.cli.plugins.gradle.configuration.GradleContext
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

class Gradle : Plugin<GradleContext>() {
	companion object {
		const val name = "gradle"
	}

	@JsonProperty(name)
	override var context: GradleContext? = null

}

@Singleton
@Factory
class GradleFactory {

	@Singleton
	fun getGradle(context: Context): GradleContext {
		println("Loading configuration of type ${Gradle::class.simpleName}")
		return context.of<Gradle>()?.context ?: GradleContext()
	}
}


@Requires(bean = GradleContext::class)
annotation class GradlePlugin
package io.github.alemazzo.architect.cli.plugins.gradle

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.context.Context
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
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
		println("Loading context of type ${Gradle::class.simpleName}")
		return context.of<Gradle>()?.context ?: GradleContext()
	}
}


@Requires(bean = GradleContext::class)
annotation class GradlePlugin
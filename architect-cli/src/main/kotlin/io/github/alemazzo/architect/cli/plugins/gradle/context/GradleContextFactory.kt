package io.github.alemazzo.architect.cli.plugins.gradle.context

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.plugins.gradle.Gradle
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class GradleContextFactory : Architect {

	@Singleton
	fun getGradle(context: Context): GradleContext {
		logger.info("Loading context of type ${Gradle::class.simpleName}")
		return context.of<Gradle>()?.context ?: GradleContext()
	}
}
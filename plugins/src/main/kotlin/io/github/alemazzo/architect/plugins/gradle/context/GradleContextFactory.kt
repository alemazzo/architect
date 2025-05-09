package io.github.alemazzo.architect.plugins.gradle.context

import io.github.alemazzo.architect.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class GradleContextFactory : AbstractContextFactory<GradleContextHolder>() {
	@Singleton
	override fun create(): GradleContextHolder = getContext()
}



package io.github.alemazzo.architect.cli.plugins.semantic.release

import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class SemanticReleaseContextFactory {

	@Singleton
	fun getSemanticRelease(context: Context): SemanticReleaseContext =
		context.of<SemanticReleasePlugin>()?.context ?: SemanticReleaseContext()
}
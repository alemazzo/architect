package io.github.alemazzo.architect.cli.plugins.semantic.release

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.context.Context
import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

class SemanticRelease : Plugin<SemanticReleaseContext>() {
	companion object {
		const val name = "semantic-release"
	}

	@JsonProperty(name)
	override var context: SemanticReleaseContext? = null
}

@Singleton
@Factory
class SemanticReleaseFactory {

	@Singleton
	fun getSemanticRelease(context: Context): SemanticReleaseContext =
		context.of<SemanticRelease>()?.context ?: SemanticReleaseContext()
}

@Requires(bean = SemanticReleaseContext::class)
annotation class SemanticReleasePlugin



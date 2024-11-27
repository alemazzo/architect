package io.github.alemazzo.architect.cli.plugins.semantic.release

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.semantic.release.actions.SemanticReleaseTask
import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = SemanticRelease.name,
	subcommands = [SemanticReleaseTask::class]
)
class SemanticRelease : Plugin<SemanticReleaseContext>(name) {
	companion object {
		const val name = "semantic-release"
	}

	@JsonProperty(SemanticRelease.name)
	override var context: SemanticReleaseContext? = null
}



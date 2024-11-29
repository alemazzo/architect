package io.github.alemazzo.architect.cli.plugins.semantic.release

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.semantic.release.actions.SemanticReleaseTask
import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = SemanticReleasePlugin.name,
	subcommands = [SemanticReleaseTask::class]
)
class SemanticReleasePlugin(
	@JsonProperty(name)
	override val context: SemanticReleaseContext?,
) :
	Plugin<SemanticReleaseContext>(name) {

	companion object {
		const val name = "semantic-release"
	}
}



package io.github.alemazzo.architect.cli.plugins.gradle

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleBuild
import io.github.alemazzo.architect.cli.plugins.gradle.application.ArchitectGradleTestCommand
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
import picocli.CommandLine.Command

@Command(
	name = GradleCommand.name,
	subcommands = [
		ArchitectGradleBuild::class,
		ArchitectGradleTestCommand::class
	]
)
class GradleCommand(
	@JsonProperty(name)
	override val context: GradleContext?,
) : Plugin<GradleContext>(name) {
	companion object {
		const val name = "gradle"
	}
}
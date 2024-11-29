package io.github.alemazzo.architect.cli.plugins.gradle

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.gradle.actions.ArchitectGradleBuild
import io.github.alemazzo.architect.cli.plugins.gradle.actions.ArchitectGradleTestCommand
import io.github.alemazzo.architect.cli.plugins.gradle.context.GradleContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = Gradle.name,
	subcommands = [
		ArchitectGradleBuild::class,
		ArchitectGradleTestCommand::class
	]
)
class Gradle(
	@JsonProperty(name)
	override val context: GradleContext?,
) : Plugin<GradleContext>(name) {
	companion object {
		const val name = "gradle"
	}
}
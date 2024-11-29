package io.github.alemazzo.architect.cli.plugins.conventional.commits

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.conventional.commits.actions.InstallConventionalCommits
import io.github.alemazzo.architect.cli.plugins.conventional.commits.context.ConventionalCommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = ConventionalCommits.name,
	subcommands = [InstallConventionalCommits::class]
)
class ConventionalCommits(
	@JsonProperty(name)
	override val context: ConventionalCommitsContext?,
) : Plugin<ConventionalCommitsContext>(name) {

	companion object {
		const val name = "conventional-commits"
	}
}


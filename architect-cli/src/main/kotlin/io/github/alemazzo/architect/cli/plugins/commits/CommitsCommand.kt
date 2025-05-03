package io.github.alemazzo.architect.cli.plugins.commits

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.github.alemazzo.architect.cli.plugins.commits.actions.InitCommitsCommand
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = CommitsCommand.name,
	description = ["Run the commits commands"],
	subcommands = [InitCommitsCommand::class]
)
class CommitsCommand(
	@JsonProperty(name)
	override val context: CommitsContext?,
) : Plugin<CommitsContext>(name) {

	companion object {
		const val name = "commits"
	}
}


package io.github.alemazzo.architect.cli.plugins.conventional.commits.actions

import io.github.alemazzo.architect.cli.api.command.init.Initializer
import io.github.alemazzo.architect.cli.plugins.conventional.commits.context.ConventionalCommitsContext
import io.github.alemazzo.architect.cli.utils.github.GithubConfiguration
import io.github.alemazzo.architect.cli.utils.github.GithubExecutor
import io.github.alemazzo.architect.cli.utils.github.Repository
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "install")
class InstallConventionalCommits(
	val context: ConventionalCommitsContext,
	val githubExecutor: GithubExecutor,
) :
	Initializer {

	override fun run() {
		val configuration = GithubConfiguration(
			repo = Repository(
				owner = "alemazzo",
				name = "architect-conventional-commits"
			),
			command = "./gradlew"
		)
		githubExecutor.run(configuration)
	}
}
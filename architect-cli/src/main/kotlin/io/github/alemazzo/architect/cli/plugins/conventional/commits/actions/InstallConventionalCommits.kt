package io.github.alemazzo.architect.cli.plugins.conventional.commits.actions

import io.github.alemazzo.architect.cli.api.architect.init.Initializer
import io.github.alemazzo.architect.cli.implementation.execution.GithubConfiguration
import io.github.alemazzo.architect.cli.implementation.execution.GithubExecutor
import io.github.alemazzo.architect.cli.implementation.execution.Repository
import io.github.alemazzo.architect.cli.plugins.conventional.commits.context.ConventionalCommitsContext
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
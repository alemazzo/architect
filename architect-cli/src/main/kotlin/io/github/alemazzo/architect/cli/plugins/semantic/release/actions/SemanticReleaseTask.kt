package io.github.alemazzo.architect.cli.plugins.semantic.release.actions

import io.github.alemazzo.architect.cli.api.architect.release.Releaser
import io.github.alemazzo.architect.cli.implementation.execution.GithubConfiguration
import io.github.alemazzo.architect.cli.implementation.execution.GithubExecutor
import io.github.alemazzo.architect.cli.implementation.execution.Repository
import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "release")
class SemanticReleaseTask(
	private val context: SemanticReleaseContext,
	val githubExecutor: GithubExecutor,
) : Releaser {
	override fun run() {
		logger.info("Releasing project with Semantic Release")
		val configuration = GithubConfiguration(
			repo = Repository(
				owner = "alemazzo",
				name = "architect-semantic-release"
			),
			command = "./release"
		)

		githubExecutor.run(configuration,
			preCommand = { executor ->
				context.assets.forEach { asset ->
					val copyCommand = "cp ${asset.path} ${githubExecutor.getPath(configuration)}/${asset.name}"
					executor.execute(copyCommand)
				}
			})
	}
}

package io.github.alemazzo.architect.plugins.release.application

import io.github.alemazzo.architect.engine.utils.resources.ResourceExtractor
import io.github.alemazzo.architect.engine.utils.executor.api.CommandExecutor
import io.github.alemazzo.architect.engine.tasks.api.release.ReleaseTask
import io.github.alemazzo.architect.plugins.release.context.ReleasesContext
import io.micronaut.core.annotation.Order
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.Files
import kotlin.io.path.Path

@Singleton
@Order(1)
@Command(name = "github-releaser", description = ["Release the application using Github"], mixinStandardHelpOptions = true)
class GithubReleaseTask(
	private val context: ReleasesContext,
	private val resourceExtractor: ResourceExtractor,
	private val commandExecutor: CommandExecutor,
	private val objectMapper: ObjectMapper,
) : ReleaseTask {

	val standardGitAssets = listOf("**/*.gradle", "**/*.gradle.kts")

	override fun run() {
		println("Github Releaser: releasing the application")
		println("Release context: $context")
		val message = objectMapper.writeValueAsString(context.release.message)
		val assetsJson = objectMapper.writeValueAsString(context.release.assets)
		val allGitAssets = standardGitAssets + context.release.git_assets
		val gitAssetsjson = objectMapper.writeValueAsString(allGitAssets)

		resourceExtractor.copyFileFromResources("releases/run.sh", Path(""), "run.sh")
		resourceExtractor.copyFileFromResources("releases/update-version.sh", Path(""), "update-version.sh")
		resourceExtractor.getResourceFileContent("releases/.releaserc.json")
			.replace("{{message}}", message)
			.replace("{{assets}}", assetsJson)
			.replace("{{git_assets}}", gitAssetsjson)
			.let { result ->
				Files.write(Path(".releaserc.json"), result.toByteArray())
			}

		commandExecutor.execute("./run.sh")

		commandExecutor.execute("rm run.sh")
		commandExecutor.execute("rm update-version.sh")
		commandExecutor.execute("rm .releaserc.json")
	}

}
package io.github.alemazzo.architect.cli.plugins.releases.application

import io.github.alemazzo.architect.cli.engine.api.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.phases.api.release.Release
import io.github.alemazzo.architect.cli.plugins.releases.context.ReleasesContext
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.Files
import kotlin.io.path.Path

@Singleton
@Command(name = "github-releaser", description = ["Release the application using Github"], mixinStandardHelpOptions = true)
class GithubReleaser(
	private val context: ReleasesContext,
	private val resourceExtractor: ResourceExtractor,
	private val commandExecutor: CommandExecutor,
	private val objectMapper: ObjectMapper,
) : Release {

	override fun run() {
		println("Github Releaser: releasing the application")
		println("Release context: $context")
		val message = objectMapper.writeValueAsString(context.release.message)
		val assetsJson = objectMapper.writeValueAsString(context.release.assets)
		val gitAssetsjson = objectMapper.writeValueAsString(context.release.git_assets)

		resourceExtractor.copyFileFromResources("plugins/releases/run.sh", Path(""), "run.sh")
		resourceExtractor.getResourceFileContent("plugins/releases/.releaserc.json")
			.replace("{{message}}", message)
			.replace("{{assets}}", assetsJson)
			.replace("{{git_assets}}", gitAssetsjson)
			.let { result ->
				Files.write(Path(".releaserc.json"), result.toByteArray())
			}

		commandExecutor.execute("./run.sh")

		commandExecutor.execute("rm run.sh")
		commandExecutor.execute("rm .releaserc.json")
	}

}
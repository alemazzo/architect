package io.github.alemazzo.architect.cli.plugins.commits.application

import io.github.alemazzo.architect.cli.engine.api.resources.ResourceExtractor
import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import io.github.alemazzo.architect.cli.plugins.hooks.api.stages.PreCommit
import jakarta.inject.Singleton
import picocli.CommandLine
import java.nio.file.Files
import java.nio.file.Path

@Singleton
@CommandLine.Command(
	name = "verify-message",
	description = ["Verify the commit"],
	mixinStandardHelpOptions = true,
)
class VerifyCommitMessagePreCommitCommand(
	val context: CommitsContext,
	val executor: CommandExecutor,
	private val resourceExtractor: ResourceExtractor
) : PreCommit {

	@CommandLine.Parameters(
		description = ["The commit message to verify"],
	)
	var commitMessageFilePath: String = ""

	override fun run() {
		println("Verifying commit message: $commitMessageFilePath")
		if (commitMessageFilePath.isEmpty()) {
			throw IllegalArgumentException("Commit message file not provided")
		}

		val convention = context.commits.type
		val filename = "verify.sh"
		resourceExtractor.copyFileFromResources("plugins/commits/$convention/verify.sh", Path.of("."), filename)
		executor.execute("./$filename $commitMessageFilePath")
		executor.execute("rm -f $filename")
	}
}
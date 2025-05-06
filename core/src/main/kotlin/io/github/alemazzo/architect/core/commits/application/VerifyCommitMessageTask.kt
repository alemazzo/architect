package io.github.alemazzo.architect.core.commits.application

import io.github.alemazzo.architect.engine.utils.resources.ResourceExtractor
import io.github.alemazzo.architect.engine.utils.executor.api.CommandExecutor
import io.github.alemazzo.architect.core.commits.context.CommitsContext
import io.github.alemazzo.architect.engine.tasks.api.commitmsg.CommitMsgTask
import jakarta.inject.Singleton
import picocli.CommandLine
import java.nio.file.Path

@Singleton
@CommandLine.Command(
	name = "verify-message",
	description = ["Verify the commit"],
	mixinStandardHelpOptions = true,
)
class VerifyCommitMessageTask(
	val context: CommitsContext,
	val executor: CommandExecutor,
	private val resourceExtractor: ResourceExtractor
) : CommitMsgTask {

	override var commitMessageFilePath: String = ""

	override fun run() {
		println("Verifying commit message: $commitMessageFilePath")
		if (commitMessageFilePath.isEmpty()) {
			throw IllegalArgumentException("Commit message file not provided")
		}

		val convention = context.commits.type
		val filename = "verify.sh"
		resourceExtractor.copyFileFromResources("commits/$convention/verify.sh", Path.of("."), filename)
		executor.execute("./$filename $commitMessageFilePath")
		executor.execute("rm -f $filename")
	}
}
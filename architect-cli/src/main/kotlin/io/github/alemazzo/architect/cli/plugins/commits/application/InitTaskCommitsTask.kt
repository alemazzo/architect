package io.github.alemazzo.architect.cli.plugins.commits.application

import io.github.alemazzo.architect.cli.engine.components.executor.api.CommandExecutor
import io.github.alemazzo.architect.cli.engine.components.tasks.api.init.InitTask
import io.github.alemazzo.architect.cli.plugins.commits.context.CommitsContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(name = "init")
class InitTaskCommitsTask(
	val context: CommitsContext,
	val executor: CommandExecutor,
) : InitTask {
	override fun run() {
		println("Initializing commits")
	}
}


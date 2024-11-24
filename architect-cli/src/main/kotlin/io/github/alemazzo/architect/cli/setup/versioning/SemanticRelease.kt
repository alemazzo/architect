package io.github.alemazzo.architect.cli.setup.versioning

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.release.Releaser
import io.github.alemazzo.architect.cli.setup.versioning.configuration.SemanticReleaseConfiguration
import io.github.alemazzo.architect.cli.utils.CommandExecutor

@Plugin
class SemanticRelease(
    private val configuration: SemanticReleaseConfiguration,
    private val commandExecutor: CommandExecutor
): Releaser {
    override fun release(): Boolean {
        println("Executing Semantic Release")
        val command = "${configuration.path}/release"
        return commandExecutor.execute(command, true)
    }
}

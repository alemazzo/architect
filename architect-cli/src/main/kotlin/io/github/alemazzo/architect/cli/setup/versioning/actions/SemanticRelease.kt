package io.github.alemazzo.architect.cli.setup.versioning.actions

import io.github.alemazzo.architect.cli.api.annotation.Plugin
import io.github.alemazzo.architect.cli.api.release.Releaser
import io.github.alemazzo.architect.cli.setup.versioning.api.RequiresSemanticRelease
import io.github.alemazzo.architect.cli.setup.versioning.api.SemanticReleaseConfiguration
import io.github.alemazzo.architect.cli.utils.CommandExecutor

@Plugin
@RequiresSemanticRelease
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

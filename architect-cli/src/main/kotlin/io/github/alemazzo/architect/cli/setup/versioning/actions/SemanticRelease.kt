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
    override fun run() {
        println("Releasing project with Semantic Release")
        commandExecutor.execute(configuration.command, false, configuration.path)
    }
}

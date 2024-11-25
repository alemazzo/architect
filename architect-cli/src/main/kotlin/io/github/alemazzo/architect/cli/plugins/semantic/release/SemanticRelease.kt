package io.github.alemazzo.architect.cli.plugins.semantic.release

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin

@Architect
class SemanticRelease : Plugin {
	override val name: String = "semantic-release"
}
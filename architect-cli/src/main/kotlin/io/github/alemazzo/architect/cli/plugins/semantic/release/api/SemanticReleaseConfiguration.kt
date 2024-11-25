package io.github.alemazzo.architect.cli.plugins.semantic.release.api

import io.github.alemazzo.architect.cli.api.task.ExecConfiguration

class SemanticReleaseConfiguration : ExecConfiguration() {
	var enabled: Boolean = false
}
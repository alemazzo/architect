package io.github.alemazzo.architect.cli.plugins.hooks.api.stages

import io.github.alemazzo.architect.cli.engine.api.ArchitectCommand

interface PrePush: ArchitectCommand {
	var remote: String
	var refspec: String
}
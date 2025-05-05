package io.github.alemazzo.architect.cli.plugins.hooks.api.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand

interface PrePush: AbstractCommand {
	var remote: String
	var refspec: String
}
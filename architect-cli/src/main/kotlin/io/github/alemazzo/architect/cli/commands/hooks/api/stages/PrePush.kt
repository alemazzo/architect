package io.github.alemazzo.architect.cli.commands.hooks.api.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand

interface PrePush: AbstractCommand {
	var remote: String
	var refspec: String
}
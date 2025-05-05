package io.github.alemazzo.architect.cli.commands.hooks.api.stages

import io.github.alemazzo.architect.cli.engine.command.api.AbstractCommand

interface PrePushCommand: AbstractCommand {
	var remote: String
	var refspec: String
}
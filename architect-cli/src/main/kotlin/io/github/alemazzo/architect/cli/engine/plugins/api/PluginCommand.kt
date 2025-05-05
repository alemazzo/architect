package io.github.alemazzo.architect.cli.engine.plugins.api

import io.github.alemazzo.architect.cli.engine.command.api.Command
import io.github.alemazzo.architect.cli.engine.utils.log.getLogger

abstract class PluginCommand<Config>(name: String) : Command(name) {
	private val logger = getLogger()

}

package io.github.alemazzo.architect.engine.plugins.api

import io.github.alemazzo.architect.engine.command.api.Command
import io.github.alemazzo.architect.engine.utils.log.getLogger

abstract class PluginCommand<Config>(name: String) : Command(name) {
	private val logger = getLogger()

}

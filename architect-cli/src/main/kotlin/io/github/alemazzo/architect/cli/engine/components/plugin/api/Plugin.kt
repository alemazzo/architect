package io.github.alemazzo.architect.cli.engine.components.plugin.api

import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent
import io.github.alemazzo.architect.cli.engine.api.log.getLogger

abstract class Plugin<Config>(name: String) : EngineComponent(name) {
	private val logger = getLogger()

}

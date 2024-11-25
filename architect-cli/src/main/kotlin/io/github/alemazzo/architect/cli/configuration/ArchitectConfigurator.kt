package io.github.alemazzo.architect.cli.configuration

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.plugin.Plugin

@Architect
class ArchitectConfigurator(
	private val configuration: ArchitectConfiguration,
	private val plugins: List<Plugin>,
) : Runnable {

	override fun run() {
		println("Configuring Architect")
		println("Configuration: ${configuration}")

		println("Initializing plugins")
		configuration.plugins.forEach {
			plugins.find { plugin -> plugin.name == it }?.let { plugin ->
				println("Configuring plugin: ${plugin.name}")
			}
		}
	}
}


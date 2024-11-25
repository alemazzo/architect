package io.github.alemazzo.architect.cli.configuration

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.init.Initializer
import io.github.alemazzo.architect.cli.api.plugin.Plugin
import io.micronaut.core.annotation.Order

@Architect
@Order(1)
class ArchitectConfigurator(
	private val configuration: ArchitectConfiguration,
	private val plugins: List<Plugin>,
) : Initializer {

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


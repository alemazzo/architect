package io.github.alemazzo.architect.cli.engine.components.phases.application

import io.github.alemazzo.architect.cli.engine.api.ArchitectTask
import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent

abstract class PhaseExecutor<T : ArchitectTask>(name: String, private val executables: List<T>) :
	EngineComponent(name) {

	override fun run() {
		println("Running phase: $name")
		executables.forEach { executable ->
			executable.run()
		}
		println("All executables passed")
	}
}


package io.github.alemazzo.architect.cli.engine.components.phases.application

import io.github.alemazzo.architect.cli.engine.api.ArchitectCommand
import io.github.alemazzo.architect.cli.engine.api.components.EngineComponent

abstract class PhaseExecutor<T : ArchitectCommand>(override val name: String, private val executables: List<T>) :
	ArchitectCommand, EngineComponent {

	override fun run() {
		println("Running phase executor: $name")
		executables.forEach { executable ->
			executable.run()
		}
		println("All executables passed")
	}
}


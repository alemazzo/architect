package io.github.alemazzo.architect.cli.engine.phases

import io.github.alemazzo.architect.cli.api.ArchitectCommand

abstract class PhaseExecutor<T : ArchitectCommand>(private val name: String, private val executables: List<T>) :
	ArchitectCommand {

	override fun run() {
		println("Running phase executor: $name")
		executables.forEach { executable ->
			executable.run()
		}
		println("All executables passed")
	}
}


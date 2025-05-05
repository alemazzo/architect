package io.github.alemazzo.architect.cli.engine.components.tasks.application

import io.github.alemazzo.architect.cli.engine.command.api.Command
import io.github.alemazzo.architect.cli.engine.components.tasks.api.Task

abstract class TaskCommand<T : Task>(name: String, private val executables: List<T>) :
	Command(name) {

	override fun run() {
		println("Running phase: $name")
		executables.forEach { executable ->
			executable.run()
		}
		println("All executables passed")
	}
}


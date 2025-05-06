package io.github.alemazzo.architect.engine.tasks.application

import io.github.alemazzo.architect.engine.command.api.Command
import io.github.alemazzo.architect.engine.tasks.api.Task

abstract class TaskCommand<T : Task>(name: String, private val executables: List<T>) :
	Command(name) {

	override fun run() {
		println("Running tasks: $name")
		executables.forEach { executable ->
			executable.run()
		}
		println("All executables passed")
	}
}


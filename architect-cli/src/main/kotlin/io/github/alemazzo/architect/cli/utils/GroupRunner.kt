package io.github.alemazzo.architect.cli.utils

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand

open class GroupRunner(private val commands: List<ArchitectCommand>) : ArchitectCommand {
	override fun run() {
		commands.forEach { it.run() }
	}
}
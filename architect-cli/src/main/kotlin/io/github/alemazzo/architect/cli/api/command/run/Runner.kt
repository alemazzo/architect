package io.github.alemazzo.architect.cli.api.command.run

import io.micronaut.context.annotation.Requires

interface Runner : Runnable {
	val name: String
}

@Requires(beans = [Runner::class])
annotation class ArchitectRunner
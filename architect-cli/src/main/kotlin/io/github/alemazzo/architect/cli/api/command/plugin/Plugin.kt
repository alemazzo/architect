package io.github.alemazzo.architect.cli.api.command.plugin

import io.micronaut.context.annotation.Requires

abstract class Plugin<C> {
	abstract var context: C?
}

@Requires(beans = [Plugin::class])
annotation class ArchitectPlugin
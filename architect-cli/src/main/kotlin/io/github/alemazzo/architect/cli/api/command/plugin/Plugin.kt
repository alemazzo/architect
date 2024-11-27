package io.github.alemazzo.architect.cli.api.command.plugin

abstract class Plugin<C>(val name: String) {
	abstract var context: C?
}

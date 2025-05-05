package io.github.alemazzo.architect.cli.commands.hooks.context

data class HooksContext(
	val hooks: List<String> = emptyList(),
)
package io.github.alemazzo.architect.cli.plugins.hooks.context

data class HooksContext(
	val hooks: List<String> = emptyList(),
)
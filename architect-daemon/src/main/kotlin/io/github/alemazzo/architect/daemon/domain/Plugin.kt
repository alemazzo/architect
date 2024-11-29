package io.github.alemazzo.architect.daemon.domain

class Plugin(
	val name: String,
	val commands: List<Command>
) {}

// This is effectively a @Command
class Argument(
	val name: String,
	val type: String,
	val required: Boolean
)

class Query(
	val name: String,
	val args: List<Argument>
)

class Command(
	val name: String,
	val args: List<Argument>
)

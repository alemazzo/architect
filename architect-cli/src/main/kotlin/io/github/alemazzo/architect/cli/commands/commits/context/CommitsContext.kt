package io.github.alemazzo.architect.cli.commands.commits.context

data class CommitsContext(
	val commits: CommitContext = CommitContext(),
)

data class CommitContext(
	val type: String = "conventional",
)
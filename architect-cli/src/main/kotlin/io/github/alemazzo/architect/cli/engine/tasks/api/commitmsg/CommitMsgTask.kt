package io.github.alemazzo.architect.cli.engine.tasks.api.commitmsg

import io.github.alemazzo.architect.cli.engine.tasks.api.Task

interface CommitMsgTask: Task {
	var commitMessageFilePath: String
}
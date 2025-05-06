package io.github.alemazzo.architect.engine.tasks.api.commitmsg

import io.github.alemazzo.architect.engine.tasks.api.Task

interface CommitMsgTask: Task {
	var commitMessageFilePath: String
}
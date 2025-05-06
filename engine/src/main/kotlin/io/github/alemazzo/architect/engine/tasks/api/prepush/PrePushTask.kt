package io.github.alemazzo.architect.engine.tasks.api.prepush

import io.github.alemazzo.architect.engine.tasks.api.Task

interface PrePushTask: Task {
	var remote: String
	var refspec: String
}
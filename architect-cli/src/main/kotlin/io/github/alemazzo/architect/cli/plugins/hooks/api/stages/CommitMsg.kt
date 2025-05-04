package io.github.alemazzo.architect.cli.plugins.hooks.api.stages

import io.github.alemazzo.architect.cli.engine.api.ArchitectTask

interface CommitMsg: ArchitectTask {
	var commitMessageFilePath: String
}
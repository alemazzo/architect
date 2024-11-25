package io.github.alemazzo.architect.cli.commands.tasks

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.github.alemazzo.architect.cli.api.command.release.Releaser
import io.github.alemazzo.architect.cli.utils.GroupRunner
import jakarta.inject.Singleton
import picocli.CommandLine.Command

@Singleton
@Command(
	name = "release",
	description = ["..."],
	mixinStandardHelpOptions = true,
)
class ReleasesRunner(releaser: List<Releaser>) : GroupRunner(releaser), ArchitectCommand
package io.github.alemazzo.architect.cli.api.command.release

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.micronaut.context.annotation.Requires

interface Releaser : ArchitectCommand

@Requires(beans = [Releaser::class])
annotation class ArchitectReleaser
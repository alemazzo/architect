package io.github.alemazzo.architect.cli.api.command.check

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.micronaut.context.annotation.Requires

interface Check : ArchitectCommand

@Requires(beans = [Check::class])
annotation class ArchitectCheck
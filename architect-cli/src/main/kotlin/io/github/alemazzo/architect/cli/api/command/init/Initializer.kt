package io.github.alemazzo.architect.cli.api.command.init

import io.github.alemazzo.architect.cli.api.command.ArchitectCommand
import io.micronaut.context.annotation.Requires

interface Initializer : ArchitectCommand

@Requires(beans = [Initializer::class])
annotation class ArchitectInitializer
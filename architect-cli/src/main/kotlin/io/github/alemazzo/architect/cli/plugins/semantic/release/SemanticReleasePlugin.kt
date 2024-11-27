package io.github.alemazzo.architect.cli.plugins.semantic.release

import io.github.alemazzo.architect.cli.plugins.semantic.release.context.SemanticReleaseContext
import io.micronaut.context.annotation.Requires

@Requires(bean = SemanticReleaseContext::class)
annotation class SemanticReleasePlugin
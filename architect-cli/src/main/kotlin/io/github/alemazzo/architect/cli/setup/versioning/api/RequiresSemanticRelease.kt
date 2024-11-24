package io.github.alemazzo.architect.cli.setup.versioning.api

import io.micronaut.context.annotation.Requires

@Requires(property = "architect.semantic-release.enabled", value = "true", defaultValue = "false")
annotation class RequiresSemanticRelease

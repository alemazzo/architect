package io.github.alemazzo.architect.cli.setup.gradle.api

import io.micronaut.context.annotation.Requires

@Requires(property = "architect.gradle.enabled", value = "true", defaultValue = "false")
annotation class RequiresGradle

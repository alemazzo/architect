package io.github.alemazzo.architect.cli.setup.gradle

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect.gradle")
class GradleExecutorConfiguration {
    val mock: Boolean = true
    var command: String = "gradle"
}
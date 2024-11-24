package io.github.alemazzo.architect.cli.setup.gradle.api

import io.github.alemazzo.architect.cli.api.task.ExecConfiguration
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect.gradle")
class GradleConfiguration: ExecConfiguration() {
    var mock: Boolean = false
    var enabled: Boolean = true
}
package io.github.alemazzo.architect.cli.setup.versioning.api

import io.github.alemazzo.architect.cli.api.task.ExecConfiguration
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect.semantic-release")
class SemanticReleaseConfiguration: ExecConfiguration() {
    var enabled: Boolean = false
}
package io.github.alemazzo.architect.cli.setup.versioning.api

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect.semantic-release")
class SemanticReleaseConfiguration {
    var enabled: Boolean = false
    var path: String = "./semantic-release"
}
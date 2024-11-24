package io.github.alemazzo.architect.cli.setup.versioning.configuration

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect.semantic-release")
class SemanticReleaseConfiguration {
    var path: String = "./semantic-release"
}
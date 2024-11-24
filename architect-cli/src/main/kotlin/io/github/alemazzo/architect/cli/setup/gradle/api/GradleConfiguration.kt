package io.github.alemazzo.architect.cli.setup.gradle.api

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect.gradle")
class GradleConfiguration {
    var mock: Boolean = false
    var path: String = "."
    var command: String = "gradlew"
    var enabled: Boolean = true
}
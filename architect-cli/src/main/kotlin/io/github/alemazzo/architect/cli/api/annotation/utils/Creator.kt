package io.github.alemazzo.architect.cli.api.annotation.utils

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Primary

@Bean
annotation class Creator

@Bean
@Primary
annotation class PrimaryCreator

@Context
annotation class Announcer


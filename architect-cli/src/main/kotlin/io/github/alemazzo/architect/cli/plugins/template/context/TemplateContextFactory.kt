package io.github.alemazzo.architect.cli.plugins.template.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class TemplateContextFactory : AbstractContextFactory<TemplateContext>() {
	@Singleton
	override fun create(): TemplateContext = getContext()
}
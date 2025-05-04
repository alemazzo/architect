package io.github.alemazzo.architect.cli.plugins.template.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.github.alemazzo.architect.cli.engine.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class TemplateContextFactory : AbstractContextFactory() {
	@Singleton
	fun getTemplateContext(context: Context): TemplateContext = getContext(context)
}
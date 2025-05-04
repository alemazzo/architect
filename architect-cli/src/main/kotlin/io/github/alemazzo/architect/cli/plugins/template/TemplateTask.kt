package io.github.alemazzo.architect.cli.plugins.template

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.template.application.TemplateInitTask
import io.github.alemazzo.architect.cli.plugins.template.application.TemplateVerifyTask
import io.github.alemazzo.architect.cli.plugins.template.context.TemplateContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = TemplateTask.NAME,
	description = ["Run the template commands"],
	subcommands = [
		TemplateInitTask::class,
		TemplateVerifyTask::class,
	]
)
class TemplateTask() : Plugin<TemplateContext>(NAME) {
	companion object {
		const val NAME = "template"
	}
}
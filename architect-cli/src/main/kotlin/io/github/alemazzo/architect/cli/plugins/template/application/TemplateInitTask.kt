package io.github.alemazzo.architect.cli.plugins.template.application

import io.github.alemazzo.architect.cli.engine.components.phases.api.init.Init
import jakarta.inject.Singleton
import picocli.CommandLine.Command



@Singleton
@Command(name = "init")
class TemplateInitTask : Init {

	override fun run() {
		println("Executing template install")
	}

}
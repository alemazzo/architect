package io.github.alemazzo.architect.cli.commands.template.application

import io.github.alemazzo.architect.cli.engine.components.tasks.api.init.InitTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command



@Singleton
@Command(name = "init")
class TemplateInitTaskTask : InitTask {

	override fun run() {
		println("Executing template install")
	}

}
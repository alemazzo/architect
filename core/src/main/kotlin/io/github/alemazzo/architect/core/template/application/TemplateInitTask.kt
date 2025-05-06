package io.github.alemazzo.architect.core.template.application

import io.github.alemazzo.architect.engine.tasks.api.init.InitTask
import jakarta.inject.Singleton
import picocli.CommandLine.Command



@Singleton
@Command(name = "init")
class TemplateInitTask : InitTask {

	override fun run() {
		println("Executing template install")
	}

}
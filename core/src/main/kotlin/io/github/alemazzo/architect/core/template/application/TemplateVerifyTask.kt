package io.github.alemazzo.architect.core.template.application

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.github.alemazzo.architect.engine.context.api.ArchitectContext
import io.github.alemazzo.architect.engine.utils.resources.ResourceExtractor
import io.github.alemazzo.architect.engine.tasks.api.verify.VerifyTask
import io.github.alemazzo.architect.core.template.context.TemplateContext
import jakarta.inject.Singleton
import picocli.CommandLine.Command
import java.nio.file.Files
import kotlin.io.path.Path

@Singleton
@Command(name = "verify")
class TemplateVerifyTask(
	val context: ArchitectContext,
	val templateContext: TemplateContext,
	val resourceExtractor: ResourceExtractor
) : VerifyTask {

	data class Folder(val path: String, val type: String = "")
	data class FoldersContext(val folders: List<Folder> = emptyList())

	data class File(val path: String, val type: String = "")
	data class FilesContext(val files: List<File> = emptyList())

	val objectMapper: ObjectMapper =
		ObjectMapper(YAMLFactory()).registerModules(KotlinModule.Builder().build())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

	override fun run() {
		println("Executing template verify")
		val resourcePath = "templates"
		val yamlFile = resourcePath + "/${templateContext.template}.${templateContext.template_format}"
		val content = resourceExtractor.getResourceFileContent(yamlFile).replace("{{main_app_name}}", context.name)
		val foldersContext = objectMapper.readValue(content, FoldersContext::class.java)
		val filesContext = objectMapper.readValue(content, FilesContext::class.java)

		// Check at first level, no folders can exists if not in folders context, same applies to files
		// Raise error on missing folders or files
		Files.list(Path("."))
			.filter { Files.isDirectory(it) }
			// Filter hidden folders
			.filter { it.fileName.toString().firstOrNull() != '.' }
			.forEach { folder ->
				val folderName = folder.fileName.toString()
				if (foldersContext.folders.none { it.path == folderName }) {
					println("Folder $folderName is not defined in the template context")
				}
			}
		Files.list(Path("."))
			.filter { Files.isRegularFile(it) }
			// Filter hidden folders
			.filter { it.fileName.toString().firstOrNull() != '.' }
			.forEach { file ->
				val fileName = file.fileName.toString()
				if (filesContext.files.none { it.path == fileName }) {
					println("File $fileName is not defined in the template context")
				}
			}
		// Check if the folders and files are in the correct path
		foldersContext.folders.forEach { folder ->
			val folderPath = Path(folder.path)
			if (!Files.exists(folderPath)) {
				println("Folder ${folder.path} does not exist")
			} else if (!Files.isDirectory(folderPath)) {
				println("Folder ${folder.path} is not a directory")
			}
		}
		filesContext.files.forEach { file ->
			val filePath = Path(file.path)
			if (!Files.exists(filePath)) {
				println("File ${file.path} does not exist")
			} else if (!Files.isRegularFile(filePath)) {
				println("File ${file.path} is not a regular file")
			}
		}
	}
}
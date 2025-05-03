package io.github.alemazzo.architect.cli.engine.api.resources

import jakarta.inject.Singleton
import java.io.InputStream
import java.net.JarURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

@Singleton
class ResourceExtractor {

    private val classLoader = Thread.currentThread().contextClassLoader

    fun copyFileFromResources(resourcePath: String, targetDir: Path, targetFileName: String? = null) {
        val inputStream = classLoader.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource file not found: $resourcePath")

        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir)
        }

        val fileName = targetFileName ?: Path.of(resourcePath).fileName.toString()
        val targetPath = targetDir.resolve(fileName)

        inputStream.use { input ->
            Files.copy(input, targetPath, StandardCopyOption.REPLACE_EXISTING)
            targetPath.toFile().setExecutable(true)
        }
    }

    fun copyDirectoryFromResources(resourceRoot: String, targetDirectory: Path) {
        val resourceUrl: URL = classLoader.getResource(resourceRoot)
            ?: throw IllegalStateException("Resource path $resourceRoot not found")

        if (!Files.exists(targetDirectory)) {
            Files.createDirectories(targetDirectory)
        }

        if (resourceUrl.protocol == "jar") {
            val connection = resourceUrl.openConnection() as JarURLConnection
            val jarFile = connection.jarFile

            jarFile.entries().asSequence()
                .filter { it.name.startsWith(resourceRoot) && !it.isDirectory }
                .forEach { entry ->
                    val relativePath = entry.name.removePrefix("$resourceRoot/")
                    val targetPath = targetDirectory.resolve(relativePath)

                    classLoader.getResourceAsStream(entry.name)?.use { input ->
                        copyExecutable(input, targetPath)
                    }
                }
        } else {
            val resourcePath = Path.of(resourceUrl.toURI())
            Files.walk(resourcePath).filter(Files::isRegularFile).forEach { source ->
                val relativePath = resourcePath.relativize(source)
                val targetPath = targetDirectory.resolve(relativePath.toString())
                Files.copy(source, targetPath, StandardCopyOption.REPLACE_EXISTING)
                targetPath.toFile().setExecutable(true)
            }
        }
    }

    fun getResourceFileContent(resourcePath: String): String {
        val inputStream = classLoader.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource file not found: $resourcePath")
        return inputStream.bufferedReader(StandardCharsets.UTF_8).use { it.readText() }
    }

    fun listResourceFiles(resourceRoot: String): List<String> {
        val resourceUrl: URL = classLoader.getResource(resourceRoot)
            ?: throw IllegalStateException("Resource path $resourceRoot not found")

        return if (resourceUrl.protocol == "jar") {
            val connection = resourceUrl.openConnection() as JarURLConnection
            val jarFile = connection.jarFile

            jarFile.entries().asSequence()
                .filter { it.name.startsWith(resourceRoot) && !it.isDirectory }
                .map { it.name.removePrefix("$resourceRoot/") }
                .toList()
        } else {
            val resourcePath = Path.of(resourceUrl.toURI())
            Files.walk(resourcePath)
                .filter(Files::isRegularFile)
                .map { resourcePath.relativize(it).toString() }
                .toList()
        }
    }

    private fun copyExecutable(input: InputStream, target: Path) {
        Files.copy(input, target, StandardCopyOption.REPLACE_EXISTING)
        target.toFile().setExecutable(true)
    }
}

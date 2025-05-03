package io.github.alemazzo.architect.cli.plugins.gradle.utils.explorer

import io.github.alemazzo.architect.cli.api.Architect
import io.github.alemazzo.architect.cli.plugins.gradle.context.ProjectContext
import java.io.File

class Package(
	val packages: List<Package>,
	val files: List<String>,
)

class Source(
	val packages: List<Package>,
	val files: List<String>,
)

class ProjectArchitecture(
	val sources: List<Source>,
	val tests: List<Source>,
)

class ProjectExplorer(private val project: ProjectContext) : Architect {

	fun getArchitecture(): ProjectArchitecture {
		logger.info("Exploring project ${project.name} at ${project.path}")

		val sourcesDirectory = project.path + "/src/main"
		val testsDirectory = project.path + "/src/test"

		val sources = exploreDirectory(sourcesDirectory)
		val tests = exploreDirectory(testsDirectory)

		return ProjectArchitecture(sources, tests)
	}

	private fun exploreDirectory(directory: String): List<Source> {
		val packages = mutableListOf<Package>()
		val files = mutableListOf<String>()

		val directoryFile = File(directory)
		val filesList = directoryFile.listFiles()

		filesList?.forEach {
			if (it.isDirectory) {
				packages.add(explorePackage(it))
			} else {
				files.add(it.name)
			}
		}

		return listOf(Source(packages, files))
	}

	private fun explorePackage(directory: File): Package {
		val packages = mutableListOf<Package>()
		val files = mutableListOf<String>()

		val filesList = directory.listFiles()

		filesList?.forEach {
			if (it.isDirectory) {
				packages.add(explorePackage(it))
			} else {
				files.add(it.name)
			}
		}
		return Package(packages, files)
	}
}
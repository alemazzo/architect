rootProject.name = "architect-project"

val projectDir = "../../"
val architectDir = "../"

includeProject("architect-cli")
includePlugin("conventional-commits")

fun includeProject(projectName: String) {
    include(projectName)
    project(":$projectName").projectDir = file("$projectDir/$projectName")
}

fun includePlugin(pluginName: String) {
    includeBuild("$architectDir/plugins/$pluginName")
}

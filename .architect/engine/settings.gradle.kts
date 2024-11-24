rootProject.name = "architect-engine"

val projectDir = "../../"
val architectDir = "../"

include("architect")
project(":architect").projectDir = file("$projectDir/application")

includeBuild("$architectDir/plugins/conventional-commits")

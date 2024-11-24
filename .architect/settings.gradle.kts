rootProject.name = "architect-project"

include("architect")
project(":architect").projectDir = file("../application")

includeBuild("./plugins/conventional-commits")

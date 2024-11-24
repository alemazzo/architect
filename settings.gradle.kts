rootProject.name = "architect-project"
include("application")

include("conventional-commits")
project(":conventional-commits").projectDir = file("architect/conventional-commits")
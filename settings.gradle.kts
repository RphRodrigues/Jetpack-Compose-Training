pluginManagement {
  repositories {
    google {
      content {
        includeGroupByRegex("com\\.android.*")
        includeGroupByRegex("com\\.google.*")
        includeGroupByRegex("androidx.*")
      }
    }
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "Compose Training"
include(":app")
include(":designSystem")
include(":codelab1")
include(":codelab1:app")
include(":codelab1:feature")
include(":codelab2")
include(":codelab2:app")
include(":codelab2:feature")
include(":codelab3")
include(":codelab3:app")
include(":codelab3:feature")
include(":codelab4")
include(":codelab4:app")
include(":codelab4:feature")
include(":codelab5")
include(":codelab5:app")
include(":codelab5:feature")

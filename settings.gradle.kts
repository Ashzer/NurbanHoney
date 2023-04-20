pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") }
    }
}
enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "NurbanHoney"
include(":app")
include(":Data")
include(":Domain")
include(":ErrorHandler")
include(":DI")

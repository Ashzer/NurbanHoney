plugins {
	`kotlin-dsl`
	`kotlin-dsl-precompiled-script-plugins`
//	kotlin("jvm") version "1.3.50" apply false
}
repositories {
	google()
	mavenCentral()
	gradlePluginPortal()
	maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") }
}

subprojects {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}

	group = "com.devjj.platform.nurbanhoney"

	version = "0.0.1"

	apply {
		plugin("org.jetbrains.kotlin.jvm")
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions.jvmTarget = "1.8"
	}
}
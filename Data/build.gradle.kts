plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.devjj.platform.nurbanhoney.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = compileSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}
dependencies {
//    implementation(kotlin("stdlib-jdk8"))

    implementation(project(":Domain"))
    implementation(project(":ErrorHandler"))

    implementation(libs.core.ktx)

    // dagger-hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // okhttp
    // define a BOM and its version
    implementation(platform(libs.okhttp.bom))
    // define any required OkHttp artifacts without version
    implementation(libs.okhttp.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // retrofit
    implementation(libs.bundles.retrofit)

    // threetenabp
    implementation(libs.threetenabp)
}

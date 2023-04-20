@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = libs.versions.namespace.get()
    compileSdk = Integer.parseInt(libs.versions.compileSdk.get())

    defaultConfig {
        applicationId = libs.versions.applicationnId.get()
        minSdk = Integer.parseInt(libs.versions.minSdk.get())
        targetSdk = compileSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            libs.versions.compose.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {

    implementation(project(":ErrorHandler"))
    implementation(project(":DI"))
    implementation(project(":Domain"))

    implementation(libs.core.ktx)
    implementation(libs.appCompat)

    // lifeCycle
    implementation(libs.bundles.lifecycle)

    // compose
    implementation(platform(libs.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    implementation(libs.compose.material)
    implementation(libs.compose.ui)
    // Android Studio Preview support
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.compiler)
    implementation(libs.compose.material.icons.core)
    implementation(libs.compose.material.icons.extended)
    // UI Tests
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.test.manifest)

    // Optional - Integration with activities
    implementation(libs.activity.compose)
    // Optional - Integration with LiveData
    implementation(libs.compose.runtime.livedata)

    // dagger-hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.core.splashscreen)
    implementation(libs.lottie.compose)
    implementation(libs.navigation.compose)
    implementation(libs.hilt.navigation.compose)

    // okhttp
    // define a BOM and its version
    implementation(platform(libs.okhttp.bom))
    // define any required OkHttp artifacts without version
    implementation(libs.okhttp.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // retrofit
    implementation(libs.bundles.retrofit)

    // coil
    implementation(libs.coil.compose)

    implementation(libs.bundles.orbit)

    implementation(libs.kakaoLogin)
}

kapt {
    correctErrorTypes = true
}

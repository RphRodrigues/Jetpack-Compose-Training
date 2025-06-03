plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)

  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "br.com.rstudio.codelab6.feature"
  compileSdk = 35

  defaultConfig {
    minSdk = 21

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    compose = true
  }
  configurations {
    implementation {
      exclude(group = "com.android.support")
    }
  }
}

dependencies {
  implementation(project(":designSystem"))

  implementation(libs.androidx.lifecycle.viewmodel.compose)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  implementation(libs.androidx.material)
  implementation(libs.androidx.material.icons.extended)
  implementation(libs.androidx.material3.window.size.class1.android)

  implementation("com.google.android.libraries.maps:maps:3.1.0-beta")
  implementation("com.google.maps.android:maps-v3-ktx:3.4.0") {
    constraints {
      // Volley is a transitive dependency of maps
      implementation("com.android.volley:volley:1.2.1") {
        because("Only volley 1.2.0 or newer are available on maven.google.com")
      }
    }
  }

  implementation("com.google.dagger:hilt-android:2.56.2")
  kapt("com.google.dagger:hilt-compiler:2.56.2")
  implementation("io.coil-kt:coil-compose:2.7.0")

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)

  androidTestImplementation("com.google.dagger:hilt-android:2.56.2")
  androidTestImplementation("com.google.dagger:hilt-android-testing:2.56.2")
  kaptAndroidTest("com.google.dagger:hilt-compiler:2.56.2")
}

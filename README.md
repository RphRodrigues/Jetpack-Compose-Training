# Compose Training Project

This project is a collection of modules created while learning and experimenting with Jetpack Compose, Android's modern toolkit for building native UI. It likely follows a series of codelabs or exercises.

## Project Structure

The project is organized into several modules:

*   `:codelab1:app`: Jetpack Compose basics
*   `:codelab2:app`: Basic layouts in Compose 
*   `:codelab3:app`: State in Jetpack Compose
*   `:codelab4:app`: Theming in Compose with Material 3

## Purpose

*   To learn and understand the fundamentals of Jetpack Compose.
*   To practice building UIs declaratively.
*   To explore different Compose concepts like Layouts, State, Navigation, Theming, etc.
*   To experiment with creating a reusable Design System module.

## Features Implemented (Example - Fill this in!)

*   **Common Theming:** A centralized theme (`DesignSystemTheme`) applied across different examples.
*   **Basic Layouts:** Use of `Column`, `Row`, `Box`, `ConstraintLayout` (if applicable).
*   **State Management:** Examples of `remember`, `mutableStateOf`, `ViewModel` usage.
*   **Navigation:** (If you've implemented it) Jetpack Compose Navigation.
*   **Lists:** Displaying dynamic lists using `LazyColumn` or `LazyRow`.

## Getting Started

### Prerequisites

*   Android Studio (latest stable version recommended - Specify version if important, e.g., Iguana or later)
*   Kotlin (version `2.0.21` or as specified in the project)
*   Gradle (configured via AGP `8.10.0` or as specified)

### Building and Running

1.  **Clone the repository:**
2.  **Open in Android Studio:**
       Open Android Studio, select "Open an Existing Project," and navigate to the cloned project directory.
3.  **Sync Gradle:**
    Allow Android Studio to sync the Gradle files. This will download all the necessary dependencies.
4.  **Run a Codelab Module:**
    *   In Android Studio, select one of the `codelabX:app` configurations from the "Edit Run/Debug Configurations" dropdown.
    *   Choose an emulator or connect a physical device.
    *   Click the "Run" button.

## Technologies Used

*   [Kotlin](https://kotlinlang.org/)
*   [Jetpack Compose](https://developer.android.com/jetpack/compose)
    *   Compose UI
    *   Compose Material 3
    *   Compose Foundation
*   [Android Gradle Plugin](https://developer.android.com/studio/releases/gradle-plugin)
*   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

## Further Learning / Codelabs Followed

*   If this project follows specific Google Codelabs, you can link to them here.
    *   Example: [Jetpack Compose Courses](https://developer.android.com/courses/jetpack-compose/course)

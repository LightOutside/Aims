# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Test Commands

```bash
./gradlew assembleDebug          # Build debug APK
./gradlew installDebug           # Build and install on connected device/emulator
./gradlew test                   # Run unit tests
./gradlew connectedAndroidTest   # Run instrumented tests (requires device/emulator)
./gradlew lint                   # Run lint checks
```

To run a single unit test class:
```bash
./gradlew test --tests "com.example.aims.ExampleUnitTest"
```

## Architecture

Single-module Android app (`app/`) with a single Activity and Jetpack Compose UI. No ViewModel, Navigation, DI, Room, or network layer — these need to be added as the app grows.

- **`MainActivity`** — sole entry point; calls `enableEdgeToEdge()`, wraps content in `AimsTheme { Scaffold { ... } }`
- **`ui/theme/`** — `Color.kt` (palette), `Theme.kt` (`AimsTheme` composable with dynamic color + dark theme support), `Type.kt` (typography)

`AimsTheme` uses dynamic colors on Android 12+ (API 31+), falling back to static Purple/Pink Material 3 schemes on older devices.

## Conventions

- All dependency versions live exclusively in `gradle/libs.versions.toml`. Never hardcode versions in `build.gradle.kts`.
- Colors must be defined in `ui/theme/Color.kt` — don't use inline `Color(0xFF...)` in composables.
- Wrap all UI in `AimsTheme { }` at the top level; use `MaterialTheme.colorScheme` / `MaterialTheme.typography` tokens inside.
- `enableEdgeToEdge()` is active — always consume `WindowInsets` (via `Scaffold`'s `innerPadding` or `windowInsetsPadding`) when laying out content.
- `@Preview` functions go directly alongside the composable they preview.
- Release minification is off (`isMinifyEnabled = false`) — enable before shipping.
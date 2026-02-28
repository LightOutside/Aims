# CLAUDE_CONTEXT.md — Aims Android Project

## Project Overview

**Aims** — Android-приложение на Jetpack Compose. На текущем этапе это стартовый шаблон, готовый к развитию.

- Package: `com.example.aims`
- Language: Kotlin 2.0.21 (100%)
- UI: Jetpack Compose + Material Design 3
- Min SDK: 28 (Android 9.0 Pie)
- Target/Compile SDK: 36 (Android 15.0)
- Java: 11

---

## Project Structure

```
Aims/
├── app/src/main/java/com/example/aims/
│   ├── MainActivity.kt              # Единственная Activity, точка входа
│   └── ui/theme/
│       ├── Color.kt                 # Цветовая палитра (Purple/Pink, светлая и тёмная)
│       ├── Theme.kt                 # AimsTheme composable, динамические цвета (Android 12+)
│       └── Type.kt                  # Material 3 Typography
├── app/build.gradle.kts             # Конфигурация модуля
├── gradle/libs.versions.toml        # Version catalog (единый источник версий)
├── build.gradle.kts                 # Root build config
└── settings.gradle.kts              # Настройки проекта, репозитории
```

---

## Tech Stack & Key Dependencies

| Категория | Библиотека / Версия |
|---|---|
| Kotlin | 2.0.21 |
| AGP | 9.0.1 |
| Compose BOM | 2024.09.00 |
| Core KTX | 1.17.0 |
| Activity Compose | 1.12.4 |
| Lifecycle Runtime | 2.10.0 |
| Material 3 | (из BOM) |
| JUnit | 4.13.2 |
| Espresso | 3.7.0 |

Все версии управляются через `gradle/libs.versions.toml`.

---

## Architecture

**Текущее состояние:** Single Activity + Jetpack Compose, без сложной архитектуры.

### Что реализовано:
- `MainActivity` (ComponentActivity) — edge-to-edge layout, Scaffold
- `AimsTheme` — Material 3 тема, поддержка тёмной темы и dynamic colors (Android 12+)
- Composable `Greeting` — пример composable-функции

### Что НЕ реализовано (потенциально нужно добавлять):
- ViewModel / StateFlow
- Repository / DataSource
- Dependency Injection (Hilt)
- Navigation (Compose Navigation)
- Room / DataStore
- Retrofit / сетевой слой
- Background tasks (WorkManager / Coroutines)

---

## Development Conventions

### Kotlin & Compose
- Использовать Kotlin-идиомы, избегать Java-style кода
- UI только на Jetpack Compose, не использовать XML layouts
- Composable-функции — PascalCase, параметры — camelCase
- State hoisting — поднимать состояние выше по дереву composables
- Preview-функции помечать `@Preview` и располагать рядом с composable

### Зависимости
- Все версии добавлять в `gradle/libs.versions.toml`
- Использовать aliases из version catalog, не хардкодить версии в `build.gradle.kts`

### Темизация
- Цвета определять в `Color.kt`, не использовать `Color(0xFF...)` inline в composables
- Типографику определять в `Type.kt`
- Тему применять через `AimsTheme { }` на верхнем уровне

---

## Build & Run

```bash
# Сборка debug APK
./gradlew assembleDebug

# Запуск unit тестов
./gradlew test

# Запуск инструментальных тестов (требует устройство/эмулятор)
./gradlew connectedAndroidTest

# Установка на устройство
./gradlew installDebug
```

---

## Key Files to Read Before Changes

| Задача | Файлы для чтения |
|---|---|
| Добавить экран | `MainActivity.kt`, понять текущий Scaffold |
| Изменить тему/цвета | `ui/theme/Color.kt`, `ui/theme/Theme.kt` |
| Добавить зависимость | `gradle/libs.versions.toml`, `app/build.gradle.kts` |
| Понять манифест | `app/src/main/AndroidManifest.xml` |

---

## Notes

- `enableEdgeToEdge()` вызывается в `MainActivity.onCreate` — учитывать insets при вёрстке
- Release build: minify отключён (`isMinifyEnabled = false`) — включить при необходимости
- Non-transitive R classes включены (`android.nonTransitiveRClass=true`)
- Проект не содержит README.md и git-репозитория
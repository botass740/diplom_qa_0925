# Приложение «Мобильный хоспис»

## Информация о студенте
**Студент:** Максим Романов  
**Группа:** QAMID-87  
**Проект:** Дипломная работа профессии Инженер по тестированию: с нуля до middle

---

## Как запустить автоматизированные тесты

### Что нужно установить
1. **Java** 11+
2. **Android Studio** (с установленным Android SDK)
3. **Gradle** (в проекте уже есть Gradle Wrapper)
4. **Эмулятор Android** или **устройство** с Android 7.0+ (API 24+)
5. (Опционально) **Allure Commandline** для HTML-отчетов: https://docs.qameta.io/allure/

### Как подготовиться к запуску
1. **Скачать проект:**
   ```bash
   git clone https://github.com/botass740/diplom_qa_0925/tree/main
   cd qamid-diplom-RM-2025
   ```

2. **Подготовить проект:**
   ```bash
   # Windows
   .\gradlew.bat clean build

   # macOS/Linux
   ./gradlew clean build
   ```

3. **Запустить эмулятор Android:**
   - Открой Android Studio
   - Найди AVD Manager
   - Запусти эмулятор с API Level 24 или новее

### Как запустить все тесты
```bash
# Windows
.\gradlew.bat connectedAndroidTest

# macOS/Linux
./gradlew connectedAndroidTest
```

### Как запустить конкретную группу тестов
```bash
# Windows
.\gradlew.bat connectedAndroidTest --tests "ru.iteco.fmhandroid.ui.tests.AuthorizationTest"

# macOS/Linux
./gradlew connectedAndroidTest --tests "ru.iteco.fmhandroid.ui.tests.AuthorizationTest"
```

### Как запустить один конкретный тест
```bash
# Windows
.\gradlew.bat connectedAndroidTest --tests "ru.iteco.fmhandroid.ui.tests.AuthorizationTest.testValidLogin"

# macOS/Linux
./gradlew connectedAndroidTest --tests "ru.iteco.fmhandroid.ui.tests.AuthorizationTest.testValidLogin"
```

### Запуск тестов через ADB (альтернатива)
```bash
# Запуск всего класса
adb shell am instrument -w -e class "ru.iteco.fmhandroid.ui.tests.AuthorizationTest" ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner

# Запуск одного тестового метода
adb shell am instrument -w -e class "ru.iteco.fmhandroid.ui.tests.AuthorizationTest#testValidLogin" ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner
```
Важно: не используйте флаг `-m` — он только выводит список тестов и не выполняет их.

### Allure-отчеты (через Allure CLI)
Тесты используют Allure Kotlin. Для HTML-отчетов установите Allure CLI.

1) Запустите тесты (см. команды выше).

2) Скопируйте результаты с устройства/эмулятора:
```bash
# Проверить наличие результатов
adb shell ls "/sdcard/Android/data/ru.iteco.fmhandroid/files/allure-results" || adb shell ls "/sdcard/allure-results"

# Скопировать результаты локально
adb pull "/sdcard/Android/data/ru.iteco.fmhandroid/files/allure-results" "./allure-results" || adb pull "/sdcard/allure-results" "./allure-results"
```

3) Откройте отчет:
```bash
# Быстрый просмотр (временный сервер)
allure serve ./allure-results

# Либо сгенерируйте статический отчет
allure generate ./allure-results -o ./allure-report --clean
```

### Где посмотреть результаты
1. **Результаты инструментальных тестов (JUnit/XML):** `app/build/outputs/androidTest-results/`
2. **Доп. вывод connected tests:** `app/build/outputs/connected_android_test_additional_output/`
3. **Allure результаты (после adb pull):** `./allure-results/`
4. **Allure статический отчет (если сгенерирован):** `./allure-report/`

### Какие тесты есть
- **AuthorizationTest** — вход в приложение
- **AboutTest** — экран "О приложении"
- **MainTest** — главная страница
- **NewsTest** — раздел новостей
- **NewsControlPanelTest** — панель управления новостями
- **ThematicQuoteTest** — экран цитат

### Если что-то не работает
1. **Ошибка "Устройство не найдено":**
   - Проверь, что эмулятор запущен
   - Напиши в командной строке: `adb devices`

2. **Ошибка при сборке:**
   - Windows: `.\\gradlew.bat clean build`
   - macOS/Linux: `./gradlew clean build`

3. **Тесты падают из-за медленной загрузки:**
   - Проверь, что эмулятор/устройство работает стабильно
   - Отключи анимации в настройках разработчика (Window/Transition/Animator scale = Off)

### Документация

1. [План автоматизации тестирования](https://github.com/botass740/diplom_qa_0925/blob/main/Plan.md)

3. [Чек-лист](https://github.com/botass740/diplom_qa_0925/blob/main/Check.xlsx)

4. [Тест-кейсы](https://github.com/botass740/diplom_qa_0925/blob/main/Case.xlsx)

5. [Отчёт о проведённом тестировании](https://github.com/botass740/diplom_qa_0925/blob/main/Result.md)

---

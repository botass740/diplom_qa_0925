# Приложение «Мобильный хоспис»

## Информация о студенте
**Студент:** Максим Романов  
**Группа:** QAMID-87  
**Проект:** Дипломная работа профессии Инженер по тестированию: с нуля до middle

---

## Как запустить автоматизированные тесты

### Что нужно установить
1. **Java** версии 11 или новее
2. **Android Studio** или **Android SDK**
3. **Gradle** (уже есть в проекте)
4. **Эмулятор Android** или **телефон** с Android 7.0 или новее

### Как подготовиться к запуску
1. **Скачать проект:**
   ```bash
   git clone <ссылка-на-репозиторий>
   cd qamid-diplom-RM-2025
   ```

2. **Подготовить проект:**
   ```bash
   ./gradlew clean
   ./gradlew build
   ```

3. **Запустить эмулятор Android:**
   - Открой Android Studio
   - Найди AVD Manager
   - Запусти эмулятор с API Level 24 или новее

### Как запустить все тесты
```bash
./gradlew connectedAndroidTest
```

### Как запустить конкретную группу тестов
```bash
./gradlew connectedAndroidTest --tests "ru.iteco.fmhandroid.ui.tests.AuthorizationTest"
```

### Как запустить один конкретный тест
```bash
./gradlew connectedAndroidTest --tests "ru.iteco.fmhandroid.ui.tests.AuthorizationTest.testValidLogin"
```

### Как получить красивый отчет
```bash
./gradlew connectedAndroidTest
./gradlew allureReport
./gradlew allureServe
```

### Где посмотреть результаты
1. **Логи тестов:** `app/build/outputs/androidTest-results/`
2. **Красивые отчеты:** `app/build/reports/allure-results/`
3. **Скриншоты:** `app/build/outputs/androidTest-results/connected/`

### Какие тесты есть
- **AuthorizationTest** - тесты входа в приложение
- **NewsTest** - тесты работы с новостями
- **MainTest** - тесты главной страницы
- **AboutTest** - тесты страницы "О приложении"
- **QuotesTest** - тесты цитат
- **AllTests** - все тесты вместе

### Если что-то не работает
1. **Ошибка "Устройство не найдено":**
   - Проверь, что эмулятор запущен
   - Напиши в командной строке: `adb devices`

2. **Ошибка при сборке:**
   - Напиши: `./gradlew clean build`

3. **Тесты падают из-за медленной загрузки:**
   - Увеличь время ожидания в DataHelper
   - Проверь, что эмулятор работает стабильно

### Настройки
- **TEST_DEVICE** - ID устройства для тестов
- **TEST_TIMEOUT** - сколько ждать элементы (по умолчанию 10 секунд)

---

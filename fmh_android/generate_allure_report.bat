@echo off
echo ========================================
echo Генерация Allure отчетов для дипломной работы
echo Автор: Максим Романов
echo Группа: QAMID-87
echo ========================================

echo.
echo 1. Очистка проекта...
call gradlew clean

echo.
echo 2. Запуск тестов...
call gradlew connectedAndroidTest

echo.
echo 3. Генерация HTML отчета...
call gradlew allureReport

echo.
echo 4. Запуск локального сервера для просмотра отчета...
call gradlew allureServe

echo.
echo ========================================
echo Отчет готов! Откройте браузер по адресу:
echo http://localhost:8080
echo ========================================
pause 
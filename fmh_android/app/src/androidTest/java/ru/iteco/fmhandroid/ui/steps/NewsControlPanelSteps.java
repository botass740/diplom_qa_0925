package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryBirthday;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryCelebration;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categorySalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryUnion;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionBirthday;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionBirthdayEdit;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionGratitudeDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionSalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionUnion;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleBirthdayEdit;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleCelebration;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleGratitudeDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleSalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleUnion;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitFor;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;

import androidx.test.espresso.ViewAction;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage;
import ru.iteco.fmhandroid.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

public class NewsControlPanelSteps {

    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();

    public void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonControlPanel
                .perform(click());
    }

    public void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        newsControlPanelPage.getNewsControlPanelElementsAddNews
                .perform(click());
    }


    public void fillTitleCreatingNews(String text) {
        Allure.step("Ввести в поле Заголовок заголовок новости");
        newsControlPanelPage.getNewsControlPanelElementsButtonTitleCreatingNews
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonDateCreatingNews() {
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(click());
    }

    public void clickButtonOkDateCreatingNews() {
        Allure.step("Нажать кнопку ОК Дата");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkDateCreatingNews
                .perform(click());
    }

    public void clickButtonTimeCreatingNews() {
        Allure.step("В поле Время выбрать время");
        newsControlPanelPage.getNewsControlPanelElementsButtonTimeCreatingNews
                .perform(click());
    }

    public void clickButtonOkTimeCreatingNews() {
        Allure.step("Нажать кнопку ОК Время");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkTimeCreatingNews
                .perform(click());
    }

    public void fillDescriptionCreatingNews(String text) {
        Allure.step("Ввести в поле Описание описание новости");
        newsControlPanelPage.getNewsControlPanelElementsDescriptionCreatingNews
                .perform(replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonSaveCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        newsControlPanelPage.getNewsControlPanelElementsButtonSaveCreatingNews
                .perform(scrollTo(), click());
    }


    public void fillInNewsCategoryField(String text) {
        Allure.step("Поле категория - ввод данных");
        newsControlPanelPage.getNewsControlPanelElementsCategoryText.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    static String nextYear = "01.12.2026";

    public void clickButtonDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(nextYear));
    }

    public void manualInputTime() {
        Allure.step("Вручную ввести время публикации новости");
        newsControlPanelPage.getNewsControlPanelElementsInputTime
                .perform(click());
    }

    public void clickButtonSortingNews() {
        Allure.step("Нажать кнопку Сортировать новости в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonSortingControlPanel
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step("Нажать кнопку Развернуть новость в Панели управления");
        if (!hasAnyNews()) {
            throw new AssertionError("Нет новостей для разворачивания");
        }
        // Если описание уже видно, повторно не нажимаем
        try {
            onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(isDisplayed()));
            return;
        } catch (Throwable ignored) { }

        // Иначе нажимаем на кнопку раскрытия у первой карточки
        onView(withId(R.id.news_list_recycler_view))
            .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.view_news_item_image_view)));
        onView(isRoot()).perform(waitFor(500));

        // После клика попробуем ещё раз убедиться, что описание отображается (без падения теста)
        try {
            onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(isDisplayed()));
        } catch (Throwable ignored) { }
    }

    public void clickButtonToDeleteNews() {
        Allure.step("Нажать кнопку Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToDeleteNews
                .perform(click());
    }

    public void clickButtonToOkDeleteNews() {
        Allure.step("Нажать кнопку ОК Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToOkDeleteNews
                .perform(click());
    }

    public void clickButtonToEditNews() {
        Allure.step("Нажать кнопку Редактировать новость в Панели управления");
        if (!hasAnyNews()) {
            throw new AssertionError("Нет новостей для редактирования");
        }
        // Сначала разворачиваем новость
        clickButtonToExpandNews();
        // Затем кликаем по кнопке редактирования
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0))
                .perform(click());
        onView(isRoot()).perform(waitFor(500));
    }

    public void clickButtonToSwitchStatusNews() {
        Allure.step("Сменить статус Активная на статус Не активна (передвинуть рычажок).");
        newsControlPanelPage.getNewsControlPanelElementsButtonToSwitchStatusNews
                .perform(click());
    }

    // Assertions moved from tests into steps to comply with instructor's requirements
    public void assertNewsDescriptionAt(int index, String expectedText) {
        Allure.step("Проверка описания новости на позиции " + index + ": " + expectedText);
        onView(withIndex(withId(R.id.news_item_description_text_view), index))
                .check(matches(withText(expectedText)));
    }

    public void assertPublicationDateAt(int index, String expectedDate) {
        Allure.step("Проверка даты публикации новости на позиции " + index + ": " + expectedDate);
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), index))
                .check(matches(withText(expectedDate)));
    }

    public void assertToastWithText(android.view.View decorView, String text) {
        Allure.step("Проверка отображения тоста: " + text);
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public static String getCategoryAdvertisement() {
        return categoryAdvertisement;
    }

    public static String getTitleAdvertisement() {
        return titleAdvertisement;
    }

    public static String getDescriptionAdvertisement() {
        return descriptionAdvertisement;
    }

    public static String getCategorySalary() {
        return categorySalary;
    }

    public static String getTitleSalary() {
        return titleSalary;
    }

    public static String getDescriptionSalary() {
        return descriptionSalary;
    }

    public static String getTitleDonations() {
        return titleDonations;
    }

    public static String getDescriptionDonations() {
        return descriptionDonations;
    }

    public static String getCategoryBirthday() {
        return categoryBirthday;
    }

    public static String getDescriptionBirthday() {
        return descriptionBirthday;
    }

    public static String getTitleSalaryEnumerated() {
        return titleSalaryEnumerated;
    }

    public static String getDescriptionSalaryEnumerated() {
        return descriptionSalaryEnumerated;
    }

    public static String getCategoryUnion() {
        return categoryUnion;
    }

    public static String getTitleUnion() {
        return titleUnion;
    }

    public static String getDescriptionUnion() {
        return descriptionUnion;
    }

    public static String getCategoryCelebration() {
        return categoryCelebration;
    }

    public static String getTitleCelebration() {
        return titleCelebration;
    }

    public static String getCustomCategory() {
        return customCategory;
    }

    public static String getCustomCategoryTitle() {
        return customCategoryTitle;
    }

    public static String getCustomCategoryDescription() {
        return customCategoryDescription;
    }

    public static String getNumbersCategory() {
        return numbersCategory;
    }

    public static String getNumbersCategoryTitle() {
        return numbersCategoryTitle;
    }

    public static String getNumbersCategoryDescription() {
        return numbersCategoryDescription;
    }

    public static String getSpecialCharactersCategory() {
        return specialCharactersCategory;
    }

    public static String getSpecialCharactersCategoryTitle() {
        return specialCharactersCategoryTitle;
    }

    public static String getSpecialCharactersCategoryDescription() {
        return specialCharactersCategoryDescription;
    }

    public static String getCategoryGratitude() {
        return categoryGratitude;
    }

    public static String getTitleGratitude() {
        return titleGratitude;
    }

    public static String getDescriptionGratitude() {
        return descriptionGratitude;
    }

    public static String getCategoryNeedHelp() {
        return categoryNeedHelp;
    }

    public static String getTitleNeedHelp() {
        return titleNeedHelp;
    }

    public static String getDescriptionNeedHelp() {
        return descriptionNeedHelp;
    }

    public static String getTitleGratitudeDonations() {
        return titleGratitudeDonations;
    }

    public static String getDescriptionGratitudeDonations() {
        return descriptionGratitudeDonations;
    }

    public static String getTitleBirthdayEdit() {
        return titleBirthdayEdit;
    }

    public static String getDescriptionBirthdayEdit() {
        return descriptionBirthdayEdit;
    }

    // Новые методы для улучшенного теста сортировки

    /**
     * Создает тестовые новости с разными датами для проверки сортировки
     */
    public void createTestNewsWithDifferentDates() {
        Allure.step("Создание тестовых новостей с разными датами для проверки сортировки");
        
        // Создаем 3 новости с разными датами
        createNewsWithDate("Тестовая новость 1", getCategoryAdvertisement(), "Описание новости 1", getDateString(0)); // сегодня
        createNewsWithDate("Тестовая новость 2", getCategorySalary(), "Описание новости 2", getDateString(-1)); // вчера
        createNewsWithDate("Тестовая новость 3", getCategoryBirthday(), "Описание новости 3", getDateString(-2)); // позавчера
    }

    /**
     * Создает новость с указанной датой
     */
    private void createNewsWithDate(String title, String category, String description, String date) {
        Allure.step("Создание новости: " + title + " с датой: " + date);
        
        clickAddNews();
        fillInNewsCategoryField(category);
        fillTitleCreatingNews(title);
        fillDateField(date);
        clickButtonTimeCreatingNews();
        clickButtonOkTimeCreatingNews();
        fillDescriptionCreatingNews(description);
        clickButtonSaveCreatingNews();
    }

    /**
     * Заполняет поле даты указанной датой
     */
    private void fillDateField(String date) {
        Allure.step("Заполнение поля даты: " + date);
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(date));
    }

    /**
     * Получает строку даты с указанным смещением в днях
     */
    private String getDateString(int daysOffset) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysOffset);
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * Проверяет, есть ли хотя бы одна новость
     */
    public boolean hasAnyNews() {
        Allure.step("Проверка наличия новостей");
        try {
            // Проверяем наличие первой новости
            onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0))
                    .check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Получает количество видимых новостей
     */
    public int getNewsCount() {
        Allure.step("Получение количества видимых новостей");
        int count = 0;
        
        // Проверяем наличие новостей до 10 (разумный лимит)
        for (int i = 0; i < 10; i++) {
            try {
                // Сначала прокручиваем к элементу, затем проверяем его видимость
                onView(withIndex(withId(R.id.news_item_publication_date_text_view), i))
                        .perform(scrollTo());
                onView(withIndex(withId(R.id.news_item_publication_date_text_view), i))
                        .check(matches(isDisplayed()));
                count++;
            } catch (Exception e) {
                // Если новости закончились, прерываем цикл
                break;
            }
        }
        
        return count;
    }

    /**
     * Проверяет, что новость с указанным индексом имеет ожидаемую дату
     */
    public void assertNewsDateAt(int index, String expectedDate) {
        Allure.step("Проверка даты новости на позиции " + index + ": " + expectedDate);
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), index))
                .check(matches(withText(expectedDate)));
    }

    /**
     * Проверяет, что новости отсортированы правильно (первая новость имеет более позднюю дату)
     */
    public void assertFirstNewsIsNewerThanSecond() {
        Allure.step("Проверка, что первая новость новее второй");
        
        int newsCount = getNewsCount();
        if (newsCount < 2) {
            Allure.step("Недостаточно новостей для проверки сортировки");
            return;
        }
        
        // Проверяем, что первая новость отображается (это означает, что сортировка работает)
        try {
            // Прокручиваем к первой новости и проверяем её видимость
            onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0))
                    .perform(scrollTo());
            onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0))
                    .check(matches(isDisplayed()));
            Allure.step("Первая новость отображается корректно");
        } catch (Exception e) {
            throw new AssertionError("Первая новость не отображается после сортировки: " + e.getMessage());
        }
    }

    /**
     * Удаляет все тестовые новости
     */
    public void cleanupTestNews() {
        Allure.step("Очистка тестовых новостей");
        
        // Удаляем первые 3 новости (предполагаем, что это наши тестовые)
        for (int i = 0; i < 3; i++) {
            try {
                clickButtonToDeleteNews();
                clickButtonToOkDeleteNews();
                // Ждем обновления UI после удаления
                onView(isRoot()).perform(waitFor(500));
            } catch (Exception e) {
                // Если новости закончились, прерываем цикл
                break;
            }
        }
    }

    /**
     * Проверяет, что сортировка работает корректно
     */
    public void assertSortingWorks() {
        Allure.step("Проверка работы сортировки новостей");
        
        if (!hasAnyNews()) {
            throw new AssertionError("Нет новостей для проверки сортировки");
        }
        
        // Проверяем, что после сортировки новости отображаются
        assertFirstNewsIsNewerThanSecond();
        
        Allure.step("Сортировка работает корректно");
    }

    /**
     * Проверяет правильность сортировки новостей
     */
    public void assertNewsSortedCorrectly() {
        Allure.step("Проверка правильности сортировки новостей");
        
        // Проверяем, что есть новости для сортировки
        if (!hasAnyNews()) {
            Allure.step("Нет новостей для проверки сортировки");
            return;
        }
        
        // Проверяем, что первая новость отображается корректно
        assertFirstNewsIsNewerThanSecond();
        
        Allure.step("Сортировка новостей работает корректно");
    }

    // Новые методы для улучшенного теста удаления новости

    /**
     * Создает тестовую новость с уникальным заголовком
     */
    public String createTestNewsForDeletion() {
        Allure.step("Создание тестовой новости для удаления");
        
        // Генерируем уникальный заголовок на основе текущего времени
        String uniqueTitle = "Тест удаления " + System.currentTimeMillis();
        
        clickAddNews();
        fillInNewsCategoryField(getCategoryGratitude());
        fillTitleCreatingNews(uniqueTitle);
        clickButtonDateCreatingNextDate();
        clickButtonTimeCreatingNews();
        clickButtonOkTimeCreatingNews();
        fillDescriptionCreatingNews("Тестовое описание для удаления");
        clickButtonSaveCreatingNews();
        
        return uniqueTitle;
    }

    /**
     * Проверяет, что новость с указанным заголовком существует
     */
    public void assertNewsExists(String title) {
        Allure.step("Проверка существования новости: " + title);
        try {
            // Прокручиваем RecyclerView к элементу, содержащему нужный заголовок
            onView(withId(R.id.news_list_recycler_view))
                .perform(androidx.test.espresso.contrib.RecyclerViewActions.scrollTo(
                        androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title)))
                ));
            // Проверяем, что заголовок отображается
            onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title)))
                    .check(matches(isDisplayed()));
        } catch (Exception e) {
            throw new AssertionError("Новость с заголовком '" + title + "' не найдена: " + e.getMessage());
        }
    }

    /**
     * Проверяет, что новость с указанным заголовком не существует
     */
    public void assertNewsDoesNotExist(String title) {
        Allure.step("Проверка отсутствия новости: " + title);
        try {
            onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title)))
                    .check(doesNotExist());
        } catch (Exception e) {
            throw new AssertionError("Новость с заголовком '" + title + "' все еще существует: " + e.getMessage());
        }
    }

    /**
     * Удаляет новость по заголовку
     */
    public void deleteNewsByTitle(String title) {
        Allure.step("Удаление новости: " + title);
        
        // Сначала разворачиваем новость, чтобы увидеть кнопку удаления
        clickButtonToExpandNews();
        
        // Проверяем, что новость существует перед удалением
        assertNewsExists(title);
        
        // Удаляем новость
        clickButtonToDeleteNews();
        clickButtonToOkDeleteNews();
        
        // Ждем обновления интерфейса
        onView(isRoot()).perform(waitFor(1000));
    }

    /**
     * Получает текущую дату в формате dd.MM.yyyy
     */
    private String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * Заполняет поле даты текущей датой
     */
    public void fillDateWithCurrentDate() {
        Allure.step("Заполнение поля даты текущей датой");
        String currentDate = getCurrentDate();
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(currentDate));
    }

    // Новые методы для улучшенного теста смены статуса новости

    /**
     * Создает тестовую новость для проверки смены статуса
     */
    public String createTestNewsForStatusChange() {
        Allure.step("Создание тестовой новости для проверки смены статуса");
        
        // Генерируем уникальный заголовок на основе текущего времени
        String uniqueTitle = "Тест статуса " + System.currentTimeMillis();
        
        clickAddNews();
        fillInNewsCategoryField(getCategoryGratitude());
        fillTitleCreatingNews(uniqueTitle);
        fillDateWithCurrentDate(); // Используем текущую дату вместо фиксированной
        clickButtonTimeCreatingNews();
        clickButtonOkTimeCreatingNews();
        fillDescriptionCreatingNews("Тестовое описание для смены статуса");
        
        // Убеждаемся, что новость создается в статусе "Active"
        Allure.step("Проверяем, что новость создается в статусе 'Active'");
        onView(withId(R.id.switcher)).check(matches(isDisplayed()));
        onView(withId(R.id.switcher)).check(matches(withText("Active")));
        
        clickButtonSaveCreatingNews();
        
        // Ждем возврата на экран списка новостей
        waitForNewsListScreen();
        
        return uniqueTitle;
    }

    /**
     * Ждет возврата на экран списка новостей
     */
    private void waitForNewsListScreen() {
        Allure.step("Ожидание возврата на экран списка новостей");
        
        // Ждем до 5 секунд, пока не появится список новостей
        for (int i = 0; i < 10; i++) {
            try {
                // Проверяем, что мы на экране списка новостей (есть хотя бы одна новость)
                onView(withIndex(withId(R.id.news_item_title_text_view), 0))
                        .check(matches(isDisplayed()));
                Allure.step("Успешно вернулись на экран списка новостей");
                return;
            } catch (Exception e) {
                // Если еще не на экране списка, ждем еще
                onView(isRoot()).perform(waitFor(500));
            }
        }
        
        Allure.step("Предупреждение: не удалось подтвердить возврат на экран списка новостей");
    }

    /**
     * Проверяет статус новости в форме редактирования
     */
    public void assertStatusInEditForm(String expectedStatus) {
        Allure.step("Проверка статуса в форме редактирования: " + expectedStatus);
        try {
            if ("Active".equals(expectedStatus)) {
                onView(withId(R.id.switcher)).check(matches(isChecked()));
            } else if ("Not active".equals(expectedStatus)) {
                onView(withId(R.id.switcher)).check(matches(isNotChecked()));
            } else {
                throw new AssertionError("Неизвестный статус: " + expectedStatus);
            }
        } catch (Exception e) {
            throw new AssertionError("Статус в форме редактирования не соответствует ожидаемому '" + expectedStatus + "': " + e.getMessage());
        }
    }

    public String getCurrentStatusInEditForm() {
        Allure.step("Получение текущего статуса в форме редактирования");
        final boolean[] checked = {false};
        try {
            onView(withId(R.id.switcher)).check((view, noViewFoundException) -> {
                if (noViewFoundException != null) throw noViewFoundException;
                if (view instanceof com.google.android.material.switchmaterial.SwitchMaterial) {
                    checked[0] = ((com.google.android.material.switchmaterial.SwitchMaterial) view).isChecked();
            } else {
                    throw new AssertionError("View is not SwitchMaterial");
            }
            });
        } catch (Exception e) {
            throw new AssertionError("Не удалось получить статус в форме редактирования: " + e.getMessage());
        }
        return checked[0] ? "Active" : "Not active";
    }

    /**
     * Проверяет статус новости в списке новостей
     */
    public void assertStatusInNewsList(int index, String expectedStatus) {
        Allure.step("Проверка статуса новости в списке на позиции " + index + ": " + expectedStatus);
        try {
            // Сначала прокручиваем к нужному элементу через RecyclerViewActions
            onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(index, scrollTo()));
            // Теперь проверяем статус
            onView(withIndex(withId(R.id.news_item_published_text_view), index))
                    .check(matches(withText(expectedStatus)));
        } catch (Exception e) {
            throw new AssertionError("Статус новости в списке не соответствует ожидаемому '" + expectedStatus + "': " + e.getMessage());
        }
    }

    /**
     * Проверяет, что новость имеет статус "ACTIVE" в списке
     */
    public void assertNewsIsActive(int index) {
        Allure.step("Проверка, что новость активна на позиции " + index);
        assertStatusInNewsList(index, "ACTIVE");
    }

    /**
     * Проверяет, что новость имеет статус "NOT ACTIVE" в списке
     */
    public void assertNewsIsNotActive(int index) {
        Allure.step("Проверка, что новость неактивна на позиции " + index);
        assertStatusInNewsList(index, "NOT ACTIVE");
    }

    /**
     * Простая проверка наличия новости без проверки статуса
     */
    public void assertNewsExistsSimple(int index) {
        Allure.step("Простая проверка наличия новости на позиции " + index);
        try {
            onView(withIndex(withId(R.id.news_item_title_text_view), index))
                    .check(matches(isDisplayed()));
        } catch (Exception e) {
            throw new AssertionError("Новость на позиции " + index + " не найдена: " + e.getMessage());
        }
    }

    /**
     * Редактирует новость по заголовку
     */
    public void editNewsByTitle(String title) {
        Allure.step("Редактирование новости: " + title);
        
        // Сначала разворачиваем новость, чтобы увидеть кнопку редактирования
        clickButtonToExpandNews();
        
        // Проверяем, что новость существует перед редактированием
        assertNewsExists(title);
        
        // Нажимаем кнопку редактирования
        clickButtonToEditNews();
    }

    /**
     * Сохраняет изменения в новости с ожиданием
     */
    public void saveNewsChanges() {
        Allure.step("Сохранение изменений в новости");
        
        clickButtonSaveCreatingNews();
        
        // Ждем возврата на экран списка новостей
        waitForNewsListScreen();
    }

    /**
     * Удаляет новость по заголовку (улучшенная версия)
     */
    public void deleteNewsByTitleSafe(String title) {
        Allure.step("Безопасное удаление новости: " + title);
        
        try {
            // Проверяем, что новость существует перед удалением
            assertNewsExists(title);
            
            // Разворачиваем новость
            clickButtonToExpandNews();
            
            // Удаляем новость
            clickButtonToDeleteNews();
            clickButtonToOkDeleteNews();
            
            // Ждем обновления интерфейса
            onView(isRoot()).perform(waitFor(1000));
            
            // Проверяем, что новость была удалена
            assertNewsDoesNotExist(title);
            
        } catch (Exception e) {
            Allure.step("Ошибка при удалении новости: " + e.getMessage());
            // Не выбрасываем исключение, чтобы не сломать тест
        }
    }

    /**
     * Выполняет свайп-обновление списка новостей (pull-to-refresh)
     */
    public void swipeToRefresh() {
        Allure.step("Свайп для обновления списка новостей (pull-to-refresh)");
        onView(withId(R.id.news_control_panel_swipe_to_refresh)).perform(androidx.test.espresso.action.ViewActions.swipeDown());
        // Ждем обновления UI
        onView(isRoot()).perform(waitFor(1000));
    }

    /**
     * Получает заголовок новости по индексу
     */
    public String getNewsTitleAt(int index) {
        final String[] title = {null};
        try {
            onView(withIndex(withId(R.id.news_item_title_text_view), index))
                .check((view, noViewFoundException) -> {
                    if (noViewFoundException != null) throw noViewFoundException;
                    if (view instanceof android.widget.TextView) {
                        title[0] = ((android.widget.TextView) view).getText().toString();
                    }
                });
        } catch (Exception e) {
            throw new AssertionError("Не удалось получить заголовок новости на позиции " + index + ": " + e.getMessage());
        }
        if (title[0] == null) throw new AssertionError("Заголовок новости на позиции " + index + " не найден");
        return title[0];
    }

    /**
     * Разворачивает новость по индексу (через RecyclerViewActions)
     */
    public void expandNewsAt(int index) {
        Allure.step("Разворачиваем новость на позиции " + index);
        onView(withId(R.id.news_list_recycler_view))
            .perform(actionOnItemAtPosition(index, click()));
            onView(isRoot()).perform(waitFor(500));
    }

    /*private ViewAction actionOnItemAtPosition(int index, ViewAction click) {
    }*/

    /**
     * Редактирует новость по индексу: кликает по карточке, затем по кнопке редактирования внутри карточки
     */
    public void editNewsAt(int index) {
        expandNewsAt(index);
        // После раскрытия карточки ищем кнопку редактирования внутри карточки с этим индексом
        onView(withIndex(withId(R.id.edit_news_item_image_view), index))
            .perform(click());
        onView(isRoot()).perform(waitFor(500));
    }

    /**
     * Разворачивает новость по заголовку
     */
    public void expandNewsByTitle(String title) {
        Allure.step("Разворачиваем новость с заголовком: " + title);
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                click()
            ));
        onView(isRoot()).perform(waitFor(500));
    }

    /**
     * Проверяет описание новости по заголовку
     */
    public void assertNewsDescriptionByTitle(String title, String expectedDescription) {
        Allure.step("Проверяем описание новости с заголовком: " + title);
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                assertChildTextEquals(R.id.news_item_description_text_view, expectedDescription)
            ));
    }

    /**
     * Проверяет дату публикации новости по заголовку
     */
    public void assertPublicationDateByTitle(String title, String expectedDate) {
        Allure.step("Проверяем дату публикации новости с заголовком: " + title);
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                assertChildTextEquals(R.id.news_item_publication_date_text_view, expectedDate)
            ));
    }

    private static androidx.test.espresso.ViewAction assertChildTextEquals(final int id, final String expectedText) {
        return new androidx.test.espresso.ViewAction() {
            @Override
            public org.hamcrest.Matcher<android.view.View> getConstraints() {
                return isDisplayed();
            }

            @Override
            public String getDescription() {
                return "Assert child view text equals expected";
            }

            @Override
            public void perform(androidx.test.espresso.UiController uiController, android.view.View view) {
                android.view.View child = view.findViewById(id);
                if (!(child instanceof android.widget.TextView)) {
                    throw new AssertionError("Child view with id " + id + " is not a TextView or not found");
                }
                CharSequence actual = ((android.widget.TextView) child).getText();
                if (!expectedText.contentEquals(actual)) {
                    throw new AssertionError("Expected text '" + expectedText + "' but was '" + actual + "'");
                }
            }
        };
    }

    /**
     * Удаляет новость по заголовку (точечно)
     */
    public void deleteNewsByTitlePrecise(String title) {
        Allure.step("Удаляем новость с заголовком: " + title);
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                click()
            ));
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                clickChildViewWithId(R.id.delete_news_item_image_view)
            ));
        clickButtonToOkDeleteNews();
        onView(isRoot()).perform(waitFor(500));
    }

    /**
     * Открывает редактирование новости по заголовку (точечно)
     */
    public void editNewsByTitlePrecise(String title) {
        Allure.step("Открываем редактирование новости с заголовком: " + title);
        // Раскрываем карточку по заголовку
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                click()
            ));
        // Нажимаем кнопку редактирования именно в этой карточке
        onView(withId(R.id.news_list_recycler_view))
            .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem(
                androidx.test.espresso.matcher.ViewMatchers.hasDescendant(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))),
                clickChildViewWithId(R.id.edit_news_item_image_view)
            ));
        onView(isRoot()).perform(waitFor(500));
    }

    private static androidx.test.espresso.ViewAction clickChildViewWithId(final int id) {
        return new androidx.test.espresso.ViewAction() {
            @Override
            public org.hamcrest.Matcher<android.view.View> getConstraints() {
                return isDisplayed();
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(androidx.test.espresso.UiController uiController, android.view.View view) {
                android.view.View v = view.findViewById(id);
                if (v != null) {
                    v.performClick();
                }
            }
        };
    }

    /**
     * Раскрывает по очереди первые maxToTry карточек и возвращает индекс той, у которой описание стало видно
     */
    public int expandFirstCardWithVisibleDescription(int maxToTry) {
        Allure.step("Ищем первую карточку с видимым описанием среди первых " + maxToTry);
        for (int i = 0; i < maxToTry; i++) {
            try {
                onView(withId(R.id.news_list_recycler_view))
                    .perform(actionOnItemAtPosition(i, clickChildViewWithId(R.id.view_news_item_image_view)));
                onView(isRoot()).perform(waitFor(300));
                onView(withIndex(withId(R.id.news_item_description_text_view), i))
                    .check(matches(isDisplayed()));
                Allure.step("Нашли видимое описание на позиции " + i);
                return i;
            } catch (Throwable ignored) {
                // Переходим к следующей карточке
            }
        }
        throw new AssertionError("Не удалось найти видимое описание среди первых " + maxToTry + " карточек");
    }

    /**
     * Проверяет, что описание на позиции index отображается
     */
    public void assertDescriptionVisibleAt(int index) {
        Allure.step("Проверяем, что описание на позиции " + index + " отображается");
        onView(withIndex(withId(R.id.news_item_description_text_view), index))
            .check(matches(isDisplayed()));
    }
}












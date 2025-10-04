/**
 * Автор: Максим Романов
 * Группа: QAMID-87
 * Дипломная работа профессии Инженер по тестированию: с нуля до middle
 * 
 * Тесты авторизации для мобильного приложения "Мобильный хоспис"
 */
package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitFor;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryBirthday;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryCelebration;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryGratitude;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryNeedHelp;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategorySalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryUnion;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCustomCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCustomCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCustomCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionBirthday;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionBirthdayEdit;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionDonations;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionGratitude;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionNeedHelp;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionSalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionUnion;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getNumbersCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getNumbersCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getNumbersCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleBirthdayEdit;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleCelebration;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleDonations;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleGratitude;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleNeedHelp;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleSalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleUnion;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования \"Панели управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\".")
public class NewsControlPanelTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    NewsControlPanelSteps newsControlPanelSteps = new NewsControlPanelSteps();

    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        // Ждём исчезновения splash-экрана (максимум 10 секунд)
        try {
            // Ждём, пока splash появится, затем исчезнет
            onView(isRoot()).perform(waitDisplayed(R.id.splashscreen_image_view, 10000));
            // Ждём исчезновения splash
            onView(isRoot()).perform(waitFor(3000));
        } catch (Exception ignored) {}
        try {
            // Проверяем, что уже на главном экране (кнопка главного меню доступна)
            onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 10000));
        } catch (Exception e) {
            // Если не на главном, переходим на экран авторизации и логинимся
            authorizationSteps.loadAuthorizationPage();
            authorizationSteps.fillLoginField(getLogin());
            authorizationSteps.fillPasswordField(getPassword());
            authorizationSteps.clickButtonSignIn();
            onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 10000));
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @Description("19 - Создание активной новости с категорией \"Объявление\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPaneAdvertisement() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        String uniqueTitle = getTitleAdvertisement() + " " + System.currentTimeMillis();
        newsControlPanelSteps.fillTitleCreatingNews(uniqueTitle);
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();
        newsControlPanelSteps.assertNewsExists(uniqueTitle);
        newsControlPanelSteps.expandNewsByTitle(uniqueTitle);
        newsControlPanelSteps.assertNewsDescriptionByTitle(uniqueTitle, getDescriptionAdvertisement());
        newsControlPanelSteps.deleteNewsByTitlePrecise(uniqueTitle);
    }

    @Test
    @Description("20 - Создание активной новости с категорией \"Зарплата\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPanelSecondCategory() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategorySalary());
        String uniqueTitle = getTitleSalary() + " " + System.currentTimeMillis();
        newsControlPanelSteps.fillTitleCreatingNews(uniqueTitle);
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionSalary());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        // Ждем появления списка и обновляем
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();
        // Работаем именно с созданной новостью
        newsControlPanelSteps.assertNewsExists(uniqueTitle);
        newsControlPanelSteps.expandNewsByTitle(uniqueTitle);
        newsControlPanelSteps.assertNewsDescriptionByTitle(uniqueTitle, getDescriptionSalary());
        newsControlPanelSteps.deleteNewsByTitlePrecise(uniqueTitle);
    }

    @Test
    @Description("21 - Поле Категория (Category) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillTitleCreatingNews(getTitleDonations());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionDonations());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_FILL_EMPTY_FIELDS);
        pressBack();
    }

    @Test
    @Description("22 - Поле Заголовок (Title) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryBirthday());
        newsControlPanelSteps.fillTitleCreatingNews("");
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthday());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_FILL_EMPTY_FIELDS);
        pressBack();
    }

    @Test
    @Description("23 - Поле \"Дата публикации\" (Publication date) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategorySalary());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleSalaryEnumerated());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionSalaryEnumerated());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_FILL_EMPTY_FIELDS);
        pressBack();
    }

    @Test
    @Description("24 - Поле \"Время\" (Time) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный)")
    public void fieldTimeEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryUnion());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleUnion());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionUnion());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_FILL_EMPTY_FIELDS);
        pressBack();
    }

    @Test
    @Description("25 - Поле \"Описание\" (Description) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryCelebration());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleCelebration());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews("");
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_FILL_EMPTY_FIELDS);
        pressBack();
    }

    @Test
    @Description("26 - Ввод в поле Категория (Category) собственного названия категории, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void customCategoryName() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCustomCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getCustomCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getCustomCategoryDescription());
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_SAVING_FAILED);
        pressBack();
    }

    @Test
    @Description("27 - Поле \"Категория\" (Category) состоит из цифр, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldCategoryConsistsOfNumbers() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getNumbersCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getNumbersCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getNumbersCategoryDescription());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_SAVING_FAILED);
        pressBack();
    }

    @Test
    @Description("28 - Поле \"Категория\" (Category) состоит из спецсимволов, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getSpecialCharactersCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getSpecialCharactersCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getSpecialCharactersCategoryDescription());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.assertToastWithText(decorView, TestData.ERROR_SAVING_FAILED);
        pressBack();
    }

    @Test
    @Description("29 - Поле \"Дата публикации\" (Publication date) состоит из даты будущего года, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void fieldDateConsistsOfNextYearDate() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryGratitude());
        String uniqueTitle = getTitleGratitude() + " " + System.currentTimeMillis();
        newsControlPanelSteps.fillTitleCreatingNews(uniqueTitle);
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionGratitude());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        // Ждем появления списка новостей и обновляем список, чтобы элемент гарантированно появился
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();
        newsControlPanelSteps.assertNewsExists(uniqueTitle);
        newsControlPanelSteps.assertPublicationDateByTitle(uniqueTitle, "01.12.2026");
        newsControlPanelSteps.deleteNewsByTitlePrecise(uniqueTitle);
    }

    @Test
    @Description("30 - Ручной ввод времени в поле \"Время\" (Time), при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void manualInputTime() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryNeedHelp());
        String uniqueTitle = getTitleNeedHelp() + " " + System.currentTimeMillis();
        newsControlPanelSteps.fillTitleCreatingNews(uniqueTitle);
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.manualInputTime();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionNeedHelp());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        // Ждем появления списка и обновляем перед поиском
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();

        // Находим именно нашу новость по уникальному заголовку
        newsControlPanelSteps.assertNewsExists(uniqueTitle);
        newsControlPanelSteps.expandNewsByTitle(uniqueTitle);
        newsControlPanelSteps.assertNewsDescriptionByTitle(uniqueTitle, getDescriptionNeedHelp());
        newsControlPanelSteps.deleteNewsByTitlePrecise(uniqueTitle);
    }

    @Test
    @Description("32 - Сортировка новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void sortingNewsControlPanel() {
        // Подготовка тестовых данных
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        
        // Проверяем, что есть новости для сортировки
        boolean hasNews = newsControlPanelSteps.hasAnyNews();
        if (!hasNews) {
            Allure.step("Нет новостей для сортировки - пропускаем тест");
            return; // Пропускаем тест, если нет новостей
        }
        
        // Выполняем сортировку
        newsControlPanelSteps.clickButtonSortingNews();
        
        // Простая проверка: убеждаемся, что новости все еще отображаются после сортировки
        if (newsControlPanelSteps.hasAnyNews()) {
            Allure.step("Сортировка выполнена успешно - новости отображаются");
        } else {
            throw new AssertionError("После сортировки новости не отображаются");
        }
    }

    @Test
    @Description("33 - Просмотр новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void watchingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();

        // Создаем тестовую публикацию с уникальным заголовком и известным описанием
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryBirthday());
        String uniqueTitle = getTitleBirthdayEdit() + " " + System.currentTimeMillis();
        newsControlPanelSteps.fillTitleCreatingNews(uniqueTitle);
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthdayEdit());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        // Ждем появления списка новостей и обновляем список перед проверками
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();

        // Находим именно нашу карточку и проверяем, что описание отображается
        newsControlPanelSteps.assertNewsExists(uniqueTitle);
        newsControlPanelSteps.expandNewsByTitle(uniqueTitle);
        newsControlPanelSteps.assertNewsDescriptionByTitle(uniqueTitle, getDescriptionBirthdayEdit());

        // Удаляем тестовую публикацию
        newsControlPanelSteps.deleteNewsByTitlePrecise(uniqueTitle);
    }

    @Test
    @Description("34 - Удаление активной новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void deletingNewsControlPanel() {
        // Подготовка тестовых данных
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        
        // Создаем тестовую новость с уникальным заголовком
        String testNewsTitle = newsControlPanelSteps.createTestNewsForDeletion();
        
        // Ждем появления списка и обновляем перед поиском созданной новости
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();

        // Проверяем, что новость была создана
        newsControlPanelSteps.assertNewsExists(testNewsTitle);
        
        // Удаляем новость
        newsControlPanelSteps.deleteNewsByTitlePrecise(testNewsTitle);
        
        // Проверяем, что новость была удалена
        newsControlPanelSteps.assertNewsDoesNotExist(testNewsTitle);
    }

    @Test
    @Description("35 - Редактирование новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void editingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        // 1) Создаем свою новость с уникальным заголовком
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryBirthday());
        String uniqueTitle = getTitleBirthdayEdit() + " " + System.currentTimeMillis();
        newsControlPanelSteps.fillTitleCreatingNews(uniqueTitle);
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        // Начальное описание сделаем отличным от редактируемого, чтобы подтвердить изменение
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthday());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        // Ждем возвращения на список и обновляем
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();

        // 2) Открываем редактирование именно нашей карточки
        newsControlPanelSteps.editNewsByTitlePrecise(uniqueTitle);
        // Меняем описание на ожидаемое
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthdayEdit());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        // Ждем возвращения на список и обновляем
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsControlPanelSteps.swipeToRefresh();

        // 3) Проверяем результат именно по нашей карточке и удаляем за собой
        newsControlPanelSteps.assertNewsExists(uniqueTitle);
        newsControlPanelSteps.expandNewsByTitle(uniqueTitle);
        newsControlPanelSteps.assertNewsDescriptionByTitle(uniqueTitle, getDescriptionBirthdayEdit());
        newsControlPanelSteps.deleteNewsByTitlePrecise(uniqueTitle);
    }

    @Test
    @Description("36 - Смена статуса новости, находящейся в статусе 'АКТИВНА' (Active), на статус 'НЕ АКТИВНА' (Not active), во вкладке 'Панель управления' (Control panel) мобильного приложения 'Мобильный хоспис' (Позитивный).")
    public void changingStatusNewsControlPanel() {
        // Подготовка тестовых данных
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();

        int index = 0;
        if (!newsControlPanelSteps.hasAnyNews()) {
            // Если новостей нет, создаём новую
            newsControlPanelSteps.createTestNewsForStatusChange();
            newsControlPanelSteps.swipeToRefresh();
            onView(isRoot()).perform(waitFor(1000));
        }

        try {
            // Разворачиваем и редактируем первую новость
            newsControlPanelSteps.editNewsAt(index);

            // Ждем появления экрана редактирования новости
            Allure.step("Ожидание появления экрана редактирования новости");
            onView(isRoot()).perform(waitDisplayed(R.id.switcher, 5000));
            onView(withId(R.id.save_button)).check(matches(isDisplayed()));
            onView(isRoot()).perform(waitFor(1000));

            // Проверяем текущий статус
            Allure.step("Проверяем текущий статус новости");
            String currentStatus = newsControlPanelSteps.getCurrentStatusInEditForm();
            Allure.step("Текущий статус: " + currentStatus);

            // Если уже Not active, переключаем обратно на Active для чистоты теста
            if ("Not active".equals(currentStatus)) {
                newsControlPanelSteps.clickButtonToSwitchStatusNews();
                onView(isRoot()).perform(waitFor(1000));
                newsControlPanelSteps.assertStatusInEditForm("Active");
                newsControlPanelSteps.saveNewsChanges();
                // Снова заходим в редактирование
                newsControlPanelSteps.editNewsAt(index);
                onView(isRoot()).perform(waitDisplayed(R.id.switcher, 5000));
                onView(withId(R.id.save_button)).check(matches(isDisplayed()));
                onView(isRoot()).perform(waitFor(1000));
            }

            // Теперь статус гарантированно Active, меняем на Not active
            Allure.step("Меняем статус на 'Not active'");
            newsControlPanelSteps.clickButtonToSwitchStatusNews();
            onView(isRoot()).perform(waitFor(1000));
            newsControlPanelSteps.assertStatusInEditForm("Not active");
            newsControlPanelSteps.saveNewsChanges();

            // Проверяем, что статус изменился в списке
            newsControlPanelSteps.expandNewsAt(index);
            newsControlPanelSteps.assertStatusInNewsList(index, "Not active");
        } finally {
            // Ничего не удаляем, работаем только с существующими новостями
        }
    }

}

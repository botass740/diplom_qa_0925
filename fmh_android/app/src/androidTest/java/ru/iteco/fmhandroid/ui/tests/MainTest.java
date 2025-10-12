/**
 * Автор: Максим Романов
 * Группа: QAMID-87
 * Дипломная работа профессии Инженер по тестированию: с нуля до middle
 * 
 * Тесты авторизации для мобильного приложения "Мобильный хоспис"
 */
package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Главная страница\" (Main) мобильного приложения \"Мобильный хоспис\".")
public class MainTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainSteps.mainScreenLoad();
        } catch (Exception e) {
            authorizationSteps.fillLoginField(getLogin());
            authorizationSteps.fillPasswordField(getPassword());
            authorizationSteps.clickButtonSignIn();
            mainSteps.mainScreenLoad();
        }
    }

    @Test
    @Description("12 - Переход на вкладку \"Главная страница\" (Main) через главное меню мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void testNavigateToMainPageThroughMenu() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(withText("News")).check(matches(isDisplayed()));
        mainSteps.clickButtonMainMenu();
        mainSteps.clickButtonMain();
        onView(withText("News")).check(matches(isDisplayed()));
    }

    @Test
    @Description("13 - Свернуть/развернуть вкладку \"Новости\" (News)  на  вкладке \"Главная страница\" (Main) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void testExpandAndCollapseNewsSection() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getButtonToExpandNews(), 5000));
        // Если 'ALL NEWS' не виден — кликнуть expand
        boolean allNewsVisible = true;
        try {
            mainSteps.waitForAllNewsTextViewDisplayed();
        } catch (AssertionError e) {
            allNewsVisible = false;
        }
        if (!allNewsVisible) {
            mainSteps.clickButtonToExpandNews();
        }
        // Проверить, что 'ALL NEWS' теперь виден
        mainSteps.waitForAllNewsTextViewDisplayed();
        onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
    }
}
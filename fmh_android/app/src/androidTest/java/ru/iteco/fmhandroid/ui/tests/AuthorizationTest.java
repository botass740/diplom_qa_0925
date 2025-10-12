/**
 * Автор: Максим Романов
 * Группа: QAMID-87
 * Дипломная работа профессии Инженер по тестированию: с нуля до middle
 * 
 * Тесты авторизации для мобильного приложения "Мобильный хоспис"
 */

package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitFor;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getDifferentRegexLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getDifferentRegexPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLoginWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getOneLetterLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getOneLetterPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPasswordWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getUnregisteredLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getUnregisteredPassword;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Авторизация\" мобильного приложения \"Мобильный хоспис\".")
public class AuthorizationTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        // Ждём исчезновения splash-экрана (максимум 10 секунд)
        try {
            authorizationSteps.waitForSplashScreenDisplayed();
            // Ждём, пока splashscreen_image_view исчезнет (View.GONE)
            authorizationSteps.waitForSplashScreenDisappear(); // небольшой запас, чтобы splash точно исчез
        } catch (Exception ignored) {}
        try {
            authorizationSteps.loadAuthorizationPage();
        } catch (
                Exception e) {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
            authorizationSteps.loadAuthorizationPage();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
        } catch (Exception ignored) {
        }
    }


    @Test
    @Description("1 - Авторизация в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void testSuccessfulLoginWithValidCredentials() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.waitForAuthorizationButtonDisplayed();
        mainSteps.showTitleNewsOnMain();
        // Logout выполняется в @After
    }


    @Test
    @Description("2 - Поле \"Логин\" (Login) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithEmptyUsernameField() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField("");
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_LOGIN_PASSWORD_EMPTY);
    }

    @Test
    @Description("3 - Поле \"Логин\" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithUnregisteredUsername() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUnregisteredLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("4 - Поле \"Логин\" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithSpecialCharactersInUsername() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLoginWithSpecialCharacters());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("5 - Поле \"Логин\" (Login) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithSingleCharacterUsername() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getOneLetterLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("6 - Поле \"Логин\" (Login) состоит из букв разного регистра, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithMixedCaseUsername() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getDifferentRegexLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(isRoot()).perform(waitFor(2000)); // Даём время на обработку запроса и появление Toast
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("7 - Поле \"Пароль\" (Password) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithEmptyPasswordField() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField("");
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_LOGIN_PASSWORD_EMPTY);
    }

    @Test
    @Description("8 - Поле \"Пароль\" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithUnregisteredPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getUnregisteredPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("9 - Поле \"Пароль\" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void testLoginWithSpecialCharactersInPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPasswordWithSpecialCharacters());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("10 - Поле \"Пароль\" (Password) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный)")
    public void testLoginWithSingleCharacterPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getOneLetterPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }

    @Test
    @Description("11 - Поле \"Пароль\" (Password) состоит из букв разного регистра, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный). ")
    public void testLoginWithMixedCasePassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getDifferentRegexPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.assertToastWithText(decorView, TestData.ERROR_SOMETHING_WENT_WRONG);
    }
}

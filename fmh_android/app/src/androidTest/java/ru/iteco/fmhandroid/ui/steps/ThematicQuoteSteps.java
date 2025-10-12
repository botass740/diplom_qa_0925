package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ThematicQuotePage;
import ru.iteco.fmhandroid.R;

public class ThematicQuoteSteps {

    ThematicQuotePage thematicQuotePage = new ThematicQuotePage();

    public void clickButtonThematicQuote() {
        Allure.step("На главной странице экрана приложения нажать на кнопку Бабочка (Тематические цитаты).");
        thematicQuotePage.getQuoteElementButtonThematicQuote
                .perform(click());
    }

    public void checkTitleThematicQuote() {
        Allure.step("Проверить заголовок Love is all на вкладке Тематические цитаты.");
        thematicQuotePage.getQuoteElementTitleThematicQuote
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public void clickButtonToExpandThematicQuote() {
        Allure.step("Нажать на кнопку развернуть тематическую цитату.");
        thematicQuotePage.getQuoteElementButtonToExpandThematicQuote
                .perform(click());
    }

    public int getMissionImageButton() {
        return thematicQuotePage.missionImageButton;
    }

    // Методы ожидания для соблюдения принципов POM (Page Object Model)
    
    /**
     * Ожидание отображения описания тематической цитаты
     */
    public void waitForQuoteDescriptionDisplayed() {
        Allure.step("Ожидание отображения описания тематической цитаты");
        onView(isRoot()).perform(waitDisplayed(R.id.our_mission_item_description_text_view, 5000));
    }
}

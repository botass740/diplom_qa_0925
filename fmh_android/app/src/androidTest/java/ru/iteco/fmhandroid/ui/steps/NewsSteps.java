package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsPage;
import ru.iteco.fmhandroid.R;

public class NewsSteps {

    NewsPage newsPage = new NewsPage();

    public void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости в Главном меню");
        newsPage.getNewsButton
                .perform(click());
    }

    // Методы ожидания для соблюдения принципов POM (Page Object Model)
    
    /**
     * Ожидание отображения контейнера списка новостей
     */
    public void waitForNewsContainerDisplayed() {
        Allure.step("Ожидание отображения контейнера списка новостей");
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include, 5000));
    }
}

package ru.yandexTests.boot;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ru.yandexTests.testsLogic.NavigationHelper;
import ru.yandexTests.testsLogic.WebDriverManager;
import ru.yandexTests.testsLogic.WebDriverManager;

public class TestBase {

    protected WebDriverManager app = new WebDriverManager();

    @BeforeClass
    public void init() {
        app.getNavigationHelper();
    }

    @AfterSuite
    public void tearDown() {
        app.tearDown();
    }

}


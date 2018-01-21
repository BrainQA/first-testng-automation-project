package ru.yandexTests.testsLogic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandexTests.pages.MainPage;
import ru.yandexTests.pages.PageManager;

public class DriverBaseHelper {

    protected ChromeDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;
    //protected MainPage mainPage;

    protected DriverBaseHelper(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        pages = new PageManager(driver);
        //mainPage = new MainPage();
    }
}

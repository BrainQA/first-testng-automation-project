package ru.yandexTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Set;

public class PageManager {

    private WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public UserProfilePage userProfilePage;
    public UserManagementPage userManagementPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initElements(new LoginPage(this));
        mainPage = initElements(new MainPage(this));
        userProfilePage = initElements(new UserProfilePage(this));
        userManagementPage = initElements(new UserManagementPage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
        //PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}

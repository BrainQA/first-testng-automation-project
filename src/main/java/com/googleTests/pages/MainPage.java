package com.googleTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    //Кликпем на аватарку аккаунта
    @FindBy(xpath = "//div[@class='gb_hb gb_5c gb_Eg gb_R']")
    private WebElement accountButton;

    public void clickAccountButton() {
        accountButton.click();
    }

    //Кликаем на кнопку Войти для логина в Гугл аккаунте
    @FindBy(xpath = "//a[@class='gb_Wf gb_Fa gb_Db']")
    private WebElement enterButton;

    public void clickEnterButton() {
        enterButton.click();
    }
}
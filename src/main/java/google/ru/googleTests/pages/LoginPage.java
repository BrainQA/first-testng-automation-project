package google.ru.googleTests.pages;


import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.testsLogic.MainPageHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;

import java.awt.*;


public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @ElementTitle(value = "Кнопка Войти для логина в Гугл аккаунте")
    @FindBy(id = "gb_70")
    private WebElement enterButton;

    @ElementTitle(value = "Поле для ввода email или Номер телефона при логине")
    @FindBy(id = "identifierId")
    private WebElement emailField;

    @ElementTitle(value = "Кнопка Далее после ввода email")
    @FindBy(xpath = "//span[@class='RveJvd snByac' and text()='Далее']")
    private WebElement nextButton;

    @ElementTitle(value = "Текст предупреждающего сообщения при неверном email")
    @FindBy(xpath = ("//div[@class='dEOOab RxsGPe']"))
    private WebElement warningText;

    @ElementTitle(value = "Поле для ввода пароля при логине")
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @name='password']")
    private WebElement passwordField;

    @ElementTitle(value = "Текст предупреждающего сообщения при неверном пароле")
    @FindBy(xpath = ("//div[@class='dEOOab RxsGPe']"))
    private WebElement alertText;

    @ElementTitle(value = "Кликаем на кнопку Выйти из аккаунта")
    @FindBy(xpath = "//a[@class='gb_Ea gb_Rf gb_Zf gb_Fe gb_Eb' or @id='gb_71']")
    private WebElement logoutButton;

    @ElementTitle(value = "Аватарка аккаунта")
    @FindBy(xpath = "//div[@class='gb_hb gb_6c gb_Fg gb_R' or @class='gb_Nc gb_jb gb_Fg gb_R']")
    private WebElement accountButton;

    public WebElement getEnterButton() {
        return enterButton;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getWarningText() {
        return warningText;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getAlertText() {
        return alertText;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getAccountButton() {
        return accountButton;
    }
}
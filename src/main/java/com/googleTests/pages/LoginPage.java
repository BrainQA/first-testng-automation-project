package com.googleTests.pages;


import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.SourceProvider;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    //В поле для ввода email или Номер телефона при логине вводим email
    @FindBy(id = "identifierId")
    protected WebElement emailField;

    public void inputEmailField(String email) {
        emailField.sendKeys(email);
    }

    //В поле для ввода email или Номер телефона при логине вводим неверный email
    public void inputWrongEmailField(String wrongEmail) {
        emailField.sendKeys(wrongEmail);
    }

    //Кликаем по кнопке Далее после ввода email
    @FindBy(xpath = "//span[@class='RveJvd snByac' or text()='Далее']")
    private WebElement nextButton;

    public void clickNextButton() {
       nextButton.click();
    }

    //Текст предупреждающего сообщения при неверном email
    @FindBy(xpath = ("//div[@class='dEOOab RxsGPe']"))
    protected WebElement warningText;

    //В поле для ввода пароля при логине вводим пароль
    @FindBy(name = "password")
    protected WebElement passwordField;

    public void inputPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    //В тоже поле вводим неверный пароль
    public void inputWrongPasswordField(String wrongPassword) {
        passwordField.sendKeys(wrongPassword);
    }

    //Текст предупреждающего сообщения при неверном пароле
    @FindBy(xpath = ("//div[@class='dEOOab RxsGPe']"))
    protected WebElement alertText;

    //Тайтл страницы Защиты аккаунта
    @FindBy(xpath = ("//div[@class='N4lOwd']"))
    protected WebElement pageProtect;

    //Кликаем на кнопку Выйти из аккаунта
    @FindBy(xpath = "//a[@class='gb_Ea gb_Qf gb_Xf gb_Ee gb_Db']")
    private WebElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.click();
    }

    //@FindBy()








//    public UserProfilePage clickUserProfilePage() {
//        userProfileLink.click();
//        return pages.userProfilePage;
//    }

    @FindBy(id = "login")
    private WebElement loginField;


    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }


    public void clickLoginButton() {
        loginButton.click();
    }

//    public void setAccountButton(WebElement accountButton) {
//        this.accountButton = accountButton;
//    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(WebElement logoutButton) {
        this.logoutButton = logoutButton;
    }
}
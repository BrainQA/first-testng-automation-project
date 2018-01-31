package google.ru.googleTests.pages;


import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.testsLogic.MainPageHelper;
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

    //Кнопка Войти для логина в Гугл аккаунте
    @FindBy(id = "gb_70")
    protected WebElement enterButton;

    //Поле для ввода email или Номер телефона при логине
    @FindBy(id = "identifierId")
    protected WebElement emailField;

    //Кнопка Далее после ввода email
    @FindBy(xpath = "//span[@class='RveJvd snByac' and text()='Далее']")
    protected WebElement nextButton;

    //Текст предупреждающего сообщения при неверном email
    @FindBy(xpath = ("//div[@class='dEOOab RxsGPe']"))
    protected WebElement warningText;

    //Поле для ввода пароля при логине
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @name='password']")
    protected WebElement passwordField;

    //Текст предупреждающего сообщения при неверном пароле
    @FindBy(xpath = ("//div[@class='dEOOab RxsGPe']"))
    protected WebElement alertText;

    //Кликаем на кнопку Выйти из аккаунта
    @FindBy(xpath = "//a[@class='gb_Ea gb_Rf gb_Zf gb_Fe gb_Eb' or @id='gb_71']")
    protected WebElement logoutButton;

    //Аватарка аккаунта
    @FindBy(xpath = "//div[@class='gb_hb gb_6c gb_Fg gb_R' or @class='gb_Nc gb_jb gb_Fg gb_R']")
    protected WebElement accountButton;
}
package google.ru.googleTests.pages;

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

    //Аватарка аккаунта
    @FindBy(xpath = "//div[@class='gb_hb gb_5c gb_Eg gb_R']")
    protected WebElement accountButton;

    //Кнопка Войти для логина в Гугл аккаунте
    @FindBy(id = "gb_70")
    protected WebElement enterButton;

    //Значок Приложения Google
    @FindBy(xpath = ("//div[@class='gb_da gb_6c gb_R' or @id='gbwa']"))
    protected WebElement applicationButton;
}
package google.ru.googleTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @ElementTitle(value = "Аватарка аккаунта")
    @FindBy(xpath = "//div[@class='gb_hb gb_5c gb_Eg gb_R']")
    private WebElement accountButton;

    @ElementTitle(value = "Кнопка Войти для логина в Гугл аккаунт")
    @FindBy(id = "gb_70")
    private WebElement enterButton;

    @ElementTitle(value = "Значок Приложения Googl")
    @FindBy(xpath = ("//div[@class='gb_da gb_6c gb_R' or @id='gbwa']"))
    private WebElement applicationButton;

    public WebElement getAccountButton() {
        return accountButton;
    }

    public WebElement getEnterButton() {
        return enterButton;
    }

    public WebElement getApplicationButton() {
        return applicationButton;
    }
}
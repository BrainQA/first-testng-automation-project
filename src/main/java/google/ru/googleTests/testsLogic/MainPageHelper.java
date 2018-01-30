package google.ru.googleTests.testsLogic;

import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import google.ru.googleTests.pages.PhotosPage;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends MainPage {

    public LoginPage loginPage;
    public MainPage mainPage;
    public PhotosPage photosPage;
    public BaseSetup testBase;

    public MainPageHelper(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        photosPage = new PhotosPage(driver);
        testBase = new BaseSetup();
    }

    //Кликаем на аватарку аккаунта
    public void clickAccountButton() {
        accountButton.click();
    }

    //Кликаем на кнопку Войти для логина в Гугл аккаунт
    public void clickEnterButton() {
        enterButton.click();
    }

    //Нажимаем на значок Приложения Google
    public void clickApplicationButton() throws InterruptedException {
        applicationButton.click();
        Thread.sleep(3000);
    }
}

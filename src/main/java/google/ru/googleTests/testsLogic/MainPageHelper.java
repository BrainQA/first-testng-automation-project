package google.ru.googleTests.testsLogic;

import google.ru.googleTests.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends MainPage {

    public MainPageHelper(WebDriver driver) {
        super(driver);
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

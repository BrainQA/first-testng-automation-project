package com.googleTests;

import com.googleTests.driverBrowser.WebDriverManager;
import com.googleTests.pages.LoginPage;
import com.googleTests.pages.MainPage;
import com.googleTests.testsLogic.LoginPageHelper;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;



@Features("Google.com.googleTests")
@Stories("LoginTest. Логинимся в Google аккаунт с некорректным и корректным паролем")
public class LoginTest extends WebDriverManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private LoginPageHelper loginHelper;


    @BeforeTest
    public void setupDriver() {
        System.setProperty(chromeDr, pathChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homepage);
        System.out.println(driver.getTitle());
        driver.getCurrentUrl().equals(homepage);
        System.out.println(homepage);
}

    @Title("Инициализация данных")
    @Test()
    private void init() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        loginHelper =new LoginPageHelper(driver);
    }

    @Title("Кликаем по кнопке Войти")
    @Test(dependsOnMethods = "init")
    public void clickAccountButton() {
        mainPage.clickEnterButton();
    }

    @Title("Логинимся с несуществующим email, нажимаем кнопку Далее и проверяем Alert")
    @Test(dependsOnMethods = "clickAccountButton")
    public void inputWrongEmail() {
        loginPage.inputWrongEmailField(wrongEmail);
        loginPage.clickNextButton();
        loginHelper.checkWarningText(warningMessageWrongEmail);
    }

    @Title("Вводим верный email и нажимаем Далее")
    @Test(dependsOnMethods = "inputWrongEmail")
    public void inputEmail() {
        loginPage.inputEmailField(email);
        loginPage.clickNextButton();
    }

    @Title("Логинимся с неверный паролем, нажимаем кнопку Далее и проверяем Alert")
    @Test(dependsOnMethods = "inputEmail")
    public void inputWrongPassword() {
        loginPage.inputPasswordField(wrongPassword);
        loginPage.clickNextButton();
        loginHelper.checkAlertText(warningMessageWrongPassword);
    }

    @Title("Логинимся с верным паролем")
    @Test(dependsOnMethods = "inputWrongPassword")
    public void login() {
        loginPage.inputPasswordField(password);
        loginPage.clickNextButton();
    }

    @Title("Логаут из аккаунта")
    @Test(dependsOnMethods = "login")
    public void logout() {
        loginHelper.logout();
    }

    @Title("Убийство браузера")
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

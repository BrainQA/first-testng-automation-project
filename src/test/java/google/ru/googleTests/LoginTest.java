package google.ru.googleTests;

import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import google.ru.googleTests.testsLogic.LoginPageHelper;
import google.ru.googleTests.testsLogic.MainPageHelper;
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
public class LoginTest extends BaseSetup {

    private WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public LoginPageHelper loginPageHelper;
    public MainPageHelper mainPageHelper;


    private static class TestData {
        private static String email = "iiiiivanovivan2@gmail.com";
        private static String password = "1234567890-";
        private static String wrongPassword = "-0987654321";
        private static String wrongEmail = "ivanovi.test@yandex.ru";
        private static String warningMessageWrongPassword = "Неверный пароль. Повторите попытку или нажмите на ссылку Забыли пароль?, чтобы сбросить его.";
        private static String warningMessageWrongEmail = "Не удалось найти аккаунт Google";
    }

    @BeforeTest
    public void setupDriver() {
        System.setProperty(chromeDr, pathChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homepage);
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Url: " + driver.getCurrentUrl());
}

    @Title("Инициализация данных")
    @Test()
    public void init() {
        loginPage = new google.ru.googleTests.pages.LoginPage(driver);
        mainPage = new MainPage(driver);
        loginPageHelper = new LoginPageHelper(driver);
        mainPageHelper = new MainPageHelper(driver);
    }

    @Title("Кликаем по кнопке Войти")
    @Test(dependsOnMethods = "init")
    public void clickEnterButton() {
        mainPageHelper.clickEnterButton();
    }

    @Title("Логинимся с несуществующим email, нажимаем кнопку Далее и проверяем Alert")
    @Test(dependsOnMethods = "clickEnterButton")
    public void inputWrongEmail() {
        loginPageHelper.inputEmailField(TestData.wrongEmail);
        loginPageHelper.clickNextButton();
        loginPageHelper.checkWarningText(TestData.warningMessageWrongEmail);
    }

    @Title("Вводим верный email и нажимаем Далее")
    @Test(dependsOnMethods = "inputWrongEmail")
    public void inputEmail() {
        loginPageHelper.inputEmailField(TestData.email);
        loginPageHelper.clickNextButton();
    }

    @Title("Логинимся с неверный паролем, нажимаем кнопку Далее и проверяем Alert")
    @Test(dependsOnMethods = "inputEmail")
    public void inputWrongPassword() {
        loginPageHelper.inputPasswordField(TestData.wrongPassword);
        loginPageHelper.clickNextButton();
        loginPageHelper.checkAlertText(TestData.warningMessageWrongPassword);
    }

    @Title("Логинимся с верным паролем")
    @Test(dependsOnMethods = "inputWrongPassword")
    public void login() {
        loginPageHelper.inputPasswordField(TestData.password);
        loginPageHelper.clickNextButton();
    }

    @Title("Логаут из аккаунта")
    @Test(dependsOnMethods = "login")
    public void logout() {
        loginPageHelper.logout();
    }

    @Title("Грохаем браузер")
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

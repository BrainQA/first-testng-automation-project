package google.ru.googleTests;

import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import google.ru.googleTests.testsLogic.LoginPageHelper;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.concurrent.TimeUnit;

@Features("google.ru.googleTests")
@Stories("LoginTest. Логинимся в Google аккаунт с некорректным и корректным паролем")
public class GooglePhotosTest extends BaseSetup {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private LoginPageHelper loginPageHelper;
    protected BaseSetup baseSetup;

    private static class TestData {
        static String email = "iiiiivanovivan2@gmail.com";
        static String password = "1234567890-";
        static String wrongPassword = "-0987654321";
        static String wrongEmail = "ivanovi.test@yandex.ru";
        static String warningMessageWrongPassword = "Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.";
        static String warningMessageWrongEmail = "Не удалось найти аккаунт Google";
    }

    @BeforeTest
    public void setupDriver() {
        System.setProperty(chromeDr, pathChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homepage);
        System.out.println(driver.getTitle());
        System.out.println(homepage);
        loginPageHelper.logout();
    }

    @Title("Инициализация данных")
    @Test()
    public void init() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        loginPageHelper = new LoginPageHelper(driver);
        baseSetup = new BaseSetup();
    }
}
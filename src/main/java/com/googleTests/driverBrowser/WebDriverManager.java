package com.googleTests.driverBrowser;

import com.googleTests.pages.LoginPage;
import com.googleTests.pages.MainPage;
import com.googleTests.pages.MyAccountPage;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import ru.yandexTests.testsLogic.NavigationHelper;
import ru.yandexTests.testsLogic.UserHelper;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public LoginPage loginPage;
    public MainPage mainPage;
    public MyAccountPage myAccountPage;
    public WebDriver driver;
    //private FirefoxDriver driver;
    //protected ChromeDriver driver;
    private String baseUrl;
    private String browser;
    protected static String chromeDr = "webdriver.chrome.driver";
    protected static String firefoxDr = "webdriver.gecko.driver";
    protected static String pathChrome = "C:/Program Files/Java/chromedriver.exe";
    protected static String pathFirefox = "C:/Program Files/Java/geckodriver.exe";
    protected static String homepage = "https://google.ru/";
    protected static String email = "iiiiivanovivan2@gmail.com";
    protected static String password = "1234567890-";
    protected static String wrongPassword = "-0987654321";
    protected static String wrongEmail = "ivanovi.test@yandex.ru";
    protected static String warningMessageWrongPassword = "Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.";
    protected static String warningMessageWrongEmail = "Не удалось найти аккаунт Google";
    protected static String namePage1 = "Защитите свой аккаунт";
    protected static String namePage2 = "Мой аккаунт";

    @Title("Запуск браузера Chrome и переход на поисковую страницу google.ru")
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
    @BeforeTest
    private void init() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Title("Убийство браузера")
    @AfterTest
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

//    @BeforeTest
//    public void before() {
    //Открываем браузер

    //protected WebDriver driver;

//    @Parameters("browser")
//    @BeforeTest
//    protected WebDriver getDriver(String browser, String d) {
//        if(browser.equals("chrome")) {
//            System.setProperty(chromeDr, pathChrome);
//            driver = new ChromeDriver();
//        }
//        else if(browser.equals("firefox")) {
//            System.setProperty(firefoxDr, pathFirefox);
//            driver = new FirefoxDriver();
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        return driver;
////        driver.get(homepage);
////        userHelper = new UserHelper(driver);
////        navHelper = new NavigationHelper(driver, baseUrl);
//    }
//    }



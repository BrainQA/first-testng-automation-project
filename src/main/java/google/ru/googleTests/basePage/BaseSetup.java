package google.ru.googleTests.basePage;

import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import google.ru.googleTests.pages.MyAccountPage;
import google.ru.googleTests.pages.PhotosPage;
import google.ru.googleTests.testsLogic.LoginPageHelper;
import google.ru.googleTests.testsLogic.MainPageHelper;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class BaseSetup {

    public MainPageHelper mainPageHelper;
    public LoginPageHelper loginPageHelper;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    public MyAccountPage myAccountPage;
    public PhotosPage photosPage;
    protected WebDriver driver;
    protected WebDriverWait wait;
    //private FirefoxDriver driver;
    //protected ChromeDriver driver;
    protected static String chromeDr = "webdriver.chrome.driver";
    protected static String firefoxDr = "webdriver.gecko.driver";
    protected static String pathChrome = "C:/Java/first-testng-automation-project/src/test/resources/drivers/chromedriver.exe";
    protected static String pathFirefox = "C:/Program Files/Java/geckodriver.exe";
    protected static String homepage = "https://google.ru/";
    protected static String nameProtectPage = "Защитите свой аккаунт";
    protected static String nameMyAccountPage = "Мой аккаунт";


    @Title("Запуск браузера Chrome и переход на поисковую страницу google.ru")
    @BeforeTest
    protected void setupDriver() {
        System.setProperty(chromeDr, pathChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homepage);
        System.out.println("Page title is: " + driver.getTitle());
        //driver.getCurrentUrl().equals(homepage);
        System.out.println("Url: " + driver.getCurrentUrl());
        //loginPageHelper.logout();
    }

    @Title("Инициализация данных")
    @BeforeTest
    protected void init() {
        mainPageHelper = new MainPageHelper(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        photosPage = new PhotosPage(driver);
        loginPageHelper = new LoginPageHelper(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @Title("Убийство браузера")
    @AfterTest
    protected void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
    //protected WebDriver driver;

//    @Parameters("basePage")
//    @BeforeTest
//    protected WebDriver getDriver(String basePage, String d) {
//        if(basePage.equals("chrome")) {
//            System.setProperty(chromeDr, pathChrome);
//            driver = new ChromeDriver();
//        }
//        else if(basePage.equals("firefox")) {
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


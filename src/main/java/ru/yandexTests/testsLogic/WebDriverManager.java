package ru.yandexTests.testsLogic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import ru.yandexTests.pages.PageManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private UserHelper userHelper;
    private NavigationHelper navHelper;
    private BrowserType browserType;
//    private ChromeDriver driver;
//    private FirefoxDriver driver;
    private String baseUrl;
    private String browser;
    protected WebDriver driver;
    protected String host;
    static String chromeDr = "webdriver.chrome.driver";
    static String firefoxDr = "webdriver.gecko.driver";
    protected String pathChrome = "C:/Program Files/Java/chromedriver.exe";
    protected String pathFirefox = "C:/Program Files/Java/geckodriver.exe";
    protected String homepage = "https://yandex.ru/";

//    @BeforeTest
//    public void before() {
        //Открываем браузер

        //protected WebDriver driver;

        @Parameters("browser")
        @BeforeTest
        protected WebDriver getDriver() {
            if(browser.equals("chrome")) {
                System.setProperty(chromeDr, pathChrome);
                driver = new ChromeDriver();
            }
            else if(browser.equals("firefox")) {
                System.setProperty(firefoxDr, pathFirefox);
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return driver;
            //driver.get(homepage);
            //userHelper = new UserHelper();
            //navHelper = new NavigationHelper();
        }

//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File(path)).build();
//        driver = new ChromeDriver(service);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get(homepage);
//        userHelper = new UserHelper(driver);
//        navHelper = new NavigationHelper(driver, baseUrl);
//    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navHelper;
    }

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

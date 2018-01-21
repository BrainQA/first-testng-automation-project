package ru.yandexTests.webDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

//import org.testng.xml.annotations.BeforeTest;
import ru.yandexTests.boot.Browser;

public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";
    public static final String OPERA = "opera";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String HTML_UNIT = "htmlunit";
    public static final String IPHONE = "iphone";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String ANDROID = "android";
    public static final String XP = "xp";
    public static final String VISTA = "vista";
    public static final String MAC = "mac";
    public static final String LINUX = "linux";

    private static WebDriver webDriver = null;

//    @BeforeTest
//    public void init() {
//        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        this.driver = driver;
//    }
//
//    @BeforeTest
//    public void openBrowser() {
//        driver.manage().window().maximize();
//        driver.get("https://yandex.ru/");
//    }
//}

    /*
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     *
     * @param gridHubUrl : grid hub URI
     *
     * @param browser : Browser object containing info around the browser to hit
     *
     * @param username : username for BASIC authentication on the page to test
     *
     * @param password : password for BASIC authentication on the page to test
     *
     * @return RemoteWebDriver
     */
    public static WebDriver getInstance(String gridHubUrl, Browser browser,
                                        String username, String password) {

        WebDriver webDriver = null;

        DesiredCapabilities capability = new DesiredCapabilities();
        String browserName = browser.getName();
        capability.setJavascriptEnabled(true);

        // In case there is no Hub
        if (gridHubUrl == null || gridHubUrl.length() == 0) {
            return getInstance(browserName, username, password);
        }

        if (CHROME.equals(browserName)) {
            capability = DesiredCapabilities.chrome();
        } else if (FIREFOX.equals(browserName)) {
            capability = DesiredCapabilities.firefox();

            FirefoxProfile ffProfile = new FirefoxProfile();

            // Authenication Hack for Firefox
            if (username != null && password != null) {
                ffProfile.setPreference("network.http.phishy-userpass-length",
                        255);
                capability.setCapability(FirefoxDriver.PROFILE, ffProfile);
            }

            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        } else if (INTERNET_EXPLORER.equals(browserName)) {

            capability = DesiredCapabilities.internetExplorer();
            capability
                    .setCapability(
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                            true);
        } else if (SAFARI.equals(browserName)) {
            capability = DesiredCapabilities.safari();
        } else {

            capability = DesiredCapabilities.htmlUnit();
            // HTMLunit Check
            if (username != null && password != null) {
                webDriver = (HtmlUnitDriver) AuthenticatedDriver
                        .create(username, password);
            } else {
                webDriver = new HtmlUnitDriver(true);
            }

            return webDriver;
        }

        capability = setVersionAndPlatform(capability, browser.getVersion(),
                browser.getPlatform());

        // Create Remote webDriver
        try {
            webDriver = new RemoteWebDriver(new URL(gridHubUrl), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return webDriver;
    }

    /*
     * Factory method to return a webDriver instance given the browser to hit
     *
     * @param browser : String representing the local browser to hit
     *
     * @param username : username for BASIC authentication on the page to test
     *
     * @param password : password for BASIC authentication on the page to test
     *
     * @return webDriver instance
     */
    public static WebDriver getInstance(String browser, String username,
                                        String password) {

//        if (webDriver != null) {
//            return webDriver;
//        }

        if (CHROME.equals(browser)) {
            webDriver = new ChromeDriver();

        } else if (FIREFOX.equals(browser)) {

            FirefoxProfile ffProfile = new FirefoxProfile();

            // Authenication Hack for Firefox
            if (username != null && password != null) {
                ffProfile.setPreference("network.http.phishy-userpass-length",
                        255);
            }

            webDriver = new FirefoxDriver(

            );

        } else if (INTERNET_EXPLORER.equals(browser)) {
            webDriver = new InternetExplorerDriver();

        } else if (SAFARI.equals(browser)) {
            webDriver = new SafariDriver();

        } else {

            // HTMLunit Check
            if (username != null && password != null) {
                webDriver = (HtmlUnitDriver) AuthenticatedDriver
                        .create(username, password);
            } else {
                webDriver = new HtmlUnitDriver(true);
            }
        }

        return webDriver;
    }

    /*
     * Helper method to set version and platform for a specific browser
     *
     * @param capability : DesiredCapabilities object coming from the selected
     * browser
     *
     * @param version : browser version
     *
     * @param platform : browser platform
     *
     * @return DesiredCapabilities
     */
    private static DesiredCapabilities setVersionAndPlatform(
            DesiredCapabilities capability, String version, String platform) {
        if (MAC.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.MAC);
        } else if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);
        } else if (XP.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.XP);
        } else if (VISTA.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.VISTA);
        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        } else if (ANDROID.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.ANDROID);
        } else {
            capability.setPlatform(Platform.ANY);
        }

        if (version != null) {
            capability.setVersion(version);
        }
        return capability;
    }

    public static WebDriver getDriver(Capabilities capabilities) {
        return null;
    }
}
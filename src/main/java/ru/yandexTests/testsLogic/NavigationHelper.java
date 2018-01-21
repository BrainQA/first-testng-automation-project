package ru.yandexTests.testsLogic;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandexTests.pages.PageManager;

public class NavigationHelper extends DriverBaseHelper {

    private String baseUrl;

    NavigationHelper(ChromeDriver driver, String baseUrl) {
        super(driver);
        this.baseUrl = baseUrl;
    }

    public void openMainPage() {
        driver.get(baseUrl);
    }

    public void openRelativeUrl(String url) {
        driver.get(baseUrl + url);
    }

    public void loadedPanelMenu() {
        pages.mainPage.ensurePageLoaded();
    }

    public void gotoMarket() {
        pages.mainPage.clickMainPage();
    }

    public void gotoUserProfilePage() {
        pages.mainPage.ensurePageLoaded().clickUserProfilePage();
        //driver.findElement(By.cssSelector("nav a[href $= '?go=profile']"))
        //  .click();
        // openRelativeUrl("?go=profile");
    }

    //@Override
    public void gotoUserManagementPage() {
        pages.mainPage.ensurePageLoaded().clickUserManagementLink();
        //driver.findElement(By.cssSelector("nav a[href $= '?go=users']"))
        //  .click();
        //openRelativeUrl("?go=users");
    }

}
package ru.yandexTests.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AnyPage {

    MainPage(PageManager pages) {
        super(pages);
    }

    public MainPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath("//div[@class='col col_home-arrow']")));
        return this;
    }

    @FindBy(xpath = ".//a[text()='Маркет']")
    private WebElement marketLink;

    public void clickMainPage() {
        marketLink.click();
    }

    @FindBy(css = "nav a[href $= '?go=profile']")
    private WebElement userProfileLink;

    public UserProfilePage clickUserProfilePage() {
        userProfileLink.click();
        return pages.userProfilePage;
    }

    @FindBy(css = "nav a[href $= '?go=users']")
    private WebElement userManagementLink;

    public UserManagementPage clickUserManagementLink() {
        userManagementLink.click();
        return pages.userManagementPage;
    }

    @FindBy(css = "nav a[onclick $= '?logout']")
    private WebElement logoutLink;

    public LoginPage clickLogoutLink() {
        logoutLink.click();
        wait.until(alertIsPresent()).accept();
        return pages.loginPage;
    }
}


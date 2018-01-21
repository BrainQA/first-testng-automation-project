package ru.yandexTests.testsLogic;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandexTests.pages.UserProfilePage;
import ru.yandexTests.testData.TestsUser;

public class UserHelper extends DriverBaseHelper {

    UserHelper(ChromeDriver driver) {
        super(driver);
    }

    public void loginAs(TestsUser user) {
        pages.loginPage.ensurePageLoaded()
                .setUsernameField(user.getLogin())
                .setPasswordField(user.getPassword())
                .clickSubmitButton();
    }

    public void logout() {
        pages.mainPage.ensurePageLoaded()
                .clickLogoutLink();
    }

    public boolean isLoggedIn() {
        return pages.mainPage.waitPageLoaded();
    }

    public boolean isLoggedInAs(TestsUser user) {
        return isLoggedIn()
                && getLoggedUser().getLogin().equals(user.getLogin());
    }

    public boolean isNotLoggedIn() {
        return pages.loginPage.waitPageLoaded();
    }

    private TestsUser getLoggedUser() {
        UserProfilePage userProfile = pages.mainPage.ensurePageLoaded()
                .clickUserProfilePage()
                .ensurePageLoaded();
        return new TestsUser()
                .setLogin(userProfile.getUsername())
                .setEmail(userProfile.getEmail());
    }
}

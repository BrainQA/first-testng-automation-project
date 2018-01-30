package google.ru.googleTests.testsLogic;

import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import google.ru.googleTests.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;

public class MyAccountPageHelper extends MyAccountPage {

    private MainPage mainPage;
    private LoginPage loginPage;
    private BaseSetup webDrManager;
    private MyAccountPageHelper myAccountPageHelper;

    public MyAccountPageHelper(WebDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        webDrManager = new BaseSetup();
        myAccountPageHelper = new MyAccountPageHelper(driver);
    }

    //Проверка тайтла страницы защиты аккаунта
    public void checkPageProtection(String nameProtectPage) {
        assertTrue(pageProtect.getText().equals(nameProtectPage));
        System.out.println("Название страницы:" + " " + nameProtectPage);
    }
}

package google.ru.googleTests.testsLogic;

import google.ru.googleTests.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;


public class MyAccountPageHelper extends MyAccountPage {

    public MyAccountPageHelper(WebDriver driver) {
        super(driver);
    }

    //Проверка тайтла страницы защиты аккаунта
    public void checkPageProtection(String nameProtectPage) {
        assertTrue(pageProtect.getText().equals(nameProtectPage));
        System.out.println("Название страницы:" + " " + nameProtectPage);
    }
}

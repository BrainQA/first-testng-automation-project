package google.ru.googleTests.testsLogic;

import google.ru.googleTests.basePage.BaseSetup;
import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import google.ru.googleTests.pages.PhotosPage;
import org.openqa.selenium.WebDriver;

public class PhotosPageHelper extends PhotosPage {

    private LoginPage loginPage;
    private MainPage mainPage;
    //private PhotosPage photosPage;
    private BaseSetup webDrManager;

    public PhotosPageHelper(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        //photosPage = new PhotosPage(driver);
        webDrManager = new BaseSetup();
    }



}

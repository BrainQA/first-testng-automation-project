package google.ru.googleTests.testsLogic;

import google.ru.googleTests.pages.LoginPage;
import google.ru.googleTests.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageHelper extends LoginPage {

    //public MainPage mainPage;
    //public LoginPage loginPage;
    //public BaseSetup testBase;
    //public MainPageHelper mainPageHelper;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
        //mainPage = new MainPage(driver);
        //loginPage = new LoginPage(driver);
        //testBase = new BaseSetup();
        //mainPageHelper = new MainPageHelper(driver);
    }

    //Логинимся в аккаунт Google
    public void login(String email, String password) {
        enterButton.click();
        emailField.clear();
        emailField.sendKeys(email);
        nextButton.click();
//        passwordField.clear();
        passwordField.sendKeys(password);
        nextButton.click();
    }


    private void assertEquals(boolean equals) {
    }

    //Проверка текста предупреждающего сообщения при неверном email
    public void checkWarningText(String warningMessageWrongEmail) {
        assertEquals(warningText.getText().equals(warningMessageWrongEmail));
        System.out.println("Текст аларма: " + warningMessageWrongEmail);
        emailField.clear();
    }

    //Проверка текста предупреждающего сообщения при неверном пароле
    public void checkAlertText(String warningMessageWrongPassword) {
        assertEquals(alertText.getText().equals(warningMessageWrongPassword));
        System.out.println("Текст аларма: " + warningMessageWrongPassword);
        passwordField.clear();
    }


    //Выходим из аккаунта
    public void logout() {
        accountButton.click();
        logoutButton.click();
    }

    //В поле для ввода email или Номер телефона при логине вводим email
    public void inputEmailField(String email) {
        emailField.sendKeys(email);
    }

    //Кликаем по кнопке Далее после ввода email
    public void clickNextButton() {
        nextButton.click();
    }

    //В поле для ввода пароля при логине вводим пароль
    public void inputPasswordField(String password) {
        passwordField.sendKeys(password);
    }
}

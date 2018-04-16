package google.ru.googleTests.testsLogic;

import google.ru.googleTests.pages.LoginPage;
import org.openqa.selenium.WebDriver;


public class LoginPageHelper extends LoginPage {

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    //Логинимся в аккаунт Google
    public void login(String email, String password) {
        getEnterButton().click();
        getEmailField().clear();
        getEmailField().sendKeys(email);
        getNextButton().click();
//        passwordField.clear();
        getPasswordField().sendKeys(password);
        getNextButton().click();
    }

    private void assertEquals(boolean equals) {
    }

    //Проверка текста предупреждающего сообщения при неверном email
    public void checkWarningText(String warningMessageWrongEmail) {
        assertEquals(getWarningText().getText().equals(warningMessageWrongEmail));
        System.out.println("Текст аларма: " + warningMessageWrongEmail);
        getEmailField().clear();
    }

    //Проверка текста предупреждающего сообщения при неверном пароле
    public void checkAlertText(String warningMessageWrongPassword) {
        assertEquals(getAlertText().getText().equals(warningMessageWrongPassword));
        System.out.println("Текст аларма: " + warningMessageWrongPassword);
        getPasswordField().clear();
    }


    //Выходим из аккаунта
    public void logout() {
        getAccountButton().click();
        getLogoutButton().click();
    }

    //В поле для ввода email или Номер телефона при логине вводим email
    public void inputEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    //Кликаем по кнопке Далее после ввода email
    public void clickNextButton() {
        getNextButton().click();
    }

    //В поле для ввода пароля при логине вводим пароль
    public void inputPasswordField(String password) {
        getPasswordField().sendKeys(password);
    }
}

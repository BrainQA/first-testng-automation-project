package com.googleTests.testsLogic;

import com.googleTests.pages.LoginPage;
import com.googleTests.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class LoginPageHelper extends LoginPage {

    private MainPage mainPage;
    private LoginPage loginPage;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    //Проверка текста предупреждающего сообщения при неверном email
    public void checkWarningText(String warningMessageWrongEmail) {
        if (warningText.getText().equals(warningMessageWrongEmail)) {
            System.out.println("Текст предупреждающего сообщения:" + " " + warningMessageWrongEmail);
            emailField.clear(); }
        else {
            System.out.println("Не верный предупреждающий текст");
        }
    }

    //Проверка текста предупреждающего сообщения при неверном пароле
    public void checkAlertText(String warningMessageWrongPassword) {
        if (alertText.getText().equals(warningMessageWrongPassword)) {
            System.out.println("Текст предупреждающего сообщения:" + " " + warningMessageWrongPassword);
            passwordField.clear(); }
        else {
            System.out.println("Не верный предупреждающий текст!");
        }
    }

    //Проверка тайтла страницы защиты аккаунта
    public void checkPageProtection(String text) {
        pageProtect.getText().equals(text);
        System.out.println("Название страницы:" + " " + text);
    }

    //Выходим из аккаунта
    public void logout() {
        mainPage.clickAccountButton();
        loginPage.clickLogoutButton();
    }
}

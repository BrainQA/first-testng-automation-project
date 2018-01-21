package ru.yandexTests.testData;

public class TestsUser {

    private String login = "ivanovi.test@yandex.ru";
    private String email = "ivanovi.test@yandex.ru";
    private String password = "1234567890-";
    private String wrongPassword = "-0987654321";

    public String getLogin() {
        return login;
    }

    public TestsUser setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TestsUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TestsUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public TestsUser setWrongPassword(String wrongPassword){
        this.wrongPassword = wrongPassword;
        return this;
    }
}

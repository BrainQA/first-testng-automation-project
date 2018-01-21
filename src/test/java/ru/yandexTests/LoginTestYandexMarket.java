package ru.yandexTests;

import net.thucydides.core.annotations.Title;
import org.testng.annotations.*;
import static org.junit.Assert.*;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandexTests.testData.TestsUser;
import ru.yandexTests.boot.TestBase;

    @Features("ru.yandexTests")
    @Stories("LoginTestYandexMarket. Логаут, проверка логина на ЯндексМаркет")
    public class LoginTestYandexMarket extends TestBase {
    @Title("Логаут")
    @BeforeMethod
    public void mayBeLogout() {
        if (app.getUserHelper().isNotLoggedIn()) {
            return;
        }
        app.getUserHelper().logout();
    }

    @Title("Логинитмся на ЯндексМаркете")
    @Test
    public void testLoginOK() throws Exception {
        TestsUser user = new TestsUser().setLogin("ivanovi.test@yandex.ru").setPassword("1234567890-");
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user));
    }

    @Test
    public void testLoginFailed() throws Exception {
        TestsUser user = new TestsUser().setLogin("ivanovi.test@yandex.ru").setPassword("wrong");
        app.getUserHelper().loginAs(user);
        assertFalse(app.getUserHelper().isLoggedIn());
        assertTrue(app.getUserHelper().isNotLoggedIn());
    }
}

package ru.yandexTests;

import org.testng.annotations.*;
import static org.junit.Assert.*;

import ru.yandexTests.boot.TestBase;
import ru.yandexTests.testData.TestsUser;

public class LoginTest extends TestBase {

//    @BeforeMethod
//    public void mayBeLogout() {
//        if (app.getUserHelper().isNotLoggedIn()) {
//            return;
//        }
//        app.getUserHelper().logout();
//    }

    @Test
    public void testLoginOK() throws Exception {
        TestsUser user = new TestsUser().setLogin("admin").setPassword("admin");
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user));
    }

    @Test
    public void testLoginFailed() throws Exception {
        TestsUser user = new TestsUser().setLogin("admin").setPassword("wrong");
        app.getUserHelper().loginAs(user);
        // assertFalse(app.getUserHelper().isLoggedIn());
        assertTrue(app.getUserHelper().isNotLoggedIn());
    }

}
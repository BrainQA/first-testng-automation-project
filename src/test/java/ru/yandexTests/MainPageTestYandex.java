package ru.yandexTests;

import net.thucydides.core.annotations.Title;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandexTests.boot.TestBase;
import ru.yandexTests.testsLogic.NavigationHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Features("ru.yandexTests")
@Stories("MainPageTestYandex. Проверка загрузки главной страницы Яндекс и переход на ЯндексМаркет")
    public class MainPageTestYandex extends TestBase {

//    @BeforeMethod
//    public void setUp() {
//        //navHelper = new NavigationHelper();
//    }

    @Title("Проверяем, что панель Поиска и Меню загружены")
    @Test
    public void checkLoadedPanelMenu() {
        app.getNavigationHelper().loadedPanelMenu();
    }

    @Title("Проваливаемся по линку Маркет")
    @Test(dependsOnMethods = "checkLoadedPanelMenu")
    public void clickLinkMarket() {
        app.getNavigationHelper().gotoMarket();
        System.out.println();
    }
}
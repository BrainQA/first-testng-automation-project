package google.ru.googleTests;

import google.ru.googleTests.basePage.BaseSetup;;
import google.ru.googleTests.testsLogic.CalendarPageHelper;
import google.ru.googleTests.testsLogic.LoginPageHelper;
import google.ru.googleTests.testsLogic.MainPageHelper;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Features("Google.com.googleTests")
@Stories("CalendarTest. Логинимся в Google аккаунт, переходим в Google Календарь, загружаем 'txt' файл на сегоднящнюю дату")
public class CalendarTest extends BaseSetup {

    private WebDriver driver;
    public WebDriverWait wait;
    public LoginPageHelper loginPageHelper;
    public MainPageHelper mainPageHelper;
    public CalendarPageHelper calendarPageHelper;
    public Date currentDate;
    public SimpleDateFormat dateFormat;
    public Actions actions;

    private static class TestData {
        private static String email = "iiiiivanovivan2@gmail.com";
        private static String password = "1234567890-";
        private static String nameEvent = "I'm learn Selenium + Java";
        //private static String repeatEvent = "Ежедневно";
        private static String placeLocation = "SeleniumJava";
        private static String textDescription = "I like to learn Java!";
    }

    @BeforeTest
    public void setupDriver() {
        System.setProperty(chromeDr, pathChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homepage);
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Url: " + driver.getCurrentUrl());
    }

    @Title("Инициализация данных")
    @Test()
    public void init() {
        wait = new WebDriverWait(driver,5);
        loginPageHelper = new LoginPageHelper(driver);
        mainPageHelper = new MainPageHelper(driver);
        calendarPageHelper = new CalendarPageHelper(driver);
        currentDate = new Date();
        dateFormat = new SimpleDateFormat("yyyyMMdd");
        actions = new Actions(driver);
    }

    @Title("Логинимся в аккаунт Google")
    @Test(dependsOnMethods = "init")
    public void login() {
        loginPageHelper.login(TestData.email, TestData.password);
    }

    @Title("Заходим в приложение календарь")
    @Test(dependsOnMethods = "login")
    public void enterCalendar() throws InterruptedException {
        mainPageHelper.clickApplicationButton();
        calendarPageHelper.clickAppCalendar();
    }

    @Title("Нажимаем на кнопку Создать мероприятие")
    @Test(dependsOnMethods = "enterCalendar")
    public void createEvent() throws InterruptedException {
        calendarPageHelper.clickButtonCreateEvent();
    }

    @Title("Вводим название мероприятия в поле Добавить название")
    @Test(dependsOnMethods = "createEvent")
    public void inputNameEvent() {
        calendarPageHelper.inputNameEvent(TestData.nameEvent);
    }

    @Title("Проверяем, что текущая дата совпадает с датой создания мероприятия")
    @Test(dependsOnMethods = "inputNameEvent")
    public void checkCurrentDate() {
        System.out.println("Current Date = " + dateFormat.format(currentDate));
    }

    @Title("Проверка доступности, если да, то проcтавляем CheckBox")
    @Test(dependsOnMethods = "checkCurrentDate")
    public void verifyCheckBoxAndClick() {
        calendarPageHelper.verifyCheckBoxAndClick();
    }

    @Title("Вибираем из списка периодичности мероприятия Ежедневно")
    @Test(dependsOnMethods = "verifyCheckBoxAndClick")
    public void chooseDaily() throws InterruptedException {
        calendarPageHelper.choosePeriodicityEventDaily();
    }

    @Title("Проверяем доступность поля Укажите место проведения и вводим место проведения")
    @Test(dependsOnMethods = "chooseDaily")
    public void checkAndInputPlaceLocation() throws InterruptedException {
        calendarPageHelper.inputPlaceLocation(TestData.placeLocation);
    }

    @Title("Проверяем доступность списка Добавить видеоконференцию")
    @Test(dependsOnMethods = "checkAndInputPlaceLocation")
    public void checkListVideoConference() {
        calendarPageHelper.checkButtonAddVideoConference();
    }

    @Title("Проверяем доступность кнопки Добавить уведомление, добавляем и удаляем его")
    @Test(dependsOnMethods = "checkListVideoConference")
    public void checkButtonAddNotification() {
        calendarPageHelper.checkButtonAddNotification();
    }

    @Title("Проверяем, что email соответствует email аккаунту")
    @Test(dependsOnMethods = "checkButtonAddNotification")
    public void checkEmailAccordanceAccount() {
        calendarPageHelper.checkAccordanceEmail(TestData.email);
    }

    @Title("Создаем файл .txt на диске С")
    @Test(enabled = false)
    public void createFile() {
        calendarPageHelper.createFileTxt();
    }

    @Title("Прикрепляем файл .txt к мероприятию в календаре")
    @Test(enabled = false)
    public void attachFileForEvent() throws InterruptedException {
        calendarPageHelper.attachFileForEvent();
        // TODO: 29.01.2018 Допилить аттач файла
    }

    @Title("Проверяем доступность поля Описание и вводим текст описания")
    @Test(dependsOnMethods = "checkEmailAccordanceAccount")
    public void checkFieldDescriptionAndInputText() {
        calendarPageHelper.checkFieldDescriptionAndInputText(TestData.textDescription);
    }

    @Title("Нажимаем кнопку Сохранить мероприятие")
    @Test(dependsOnMethods = "checkFieldDescriptionAndInputText")
    public void clickButtonSave() {
        calendarPageHelper.clickButtonSave();
    }

    @Title("Проверяем, что имя сохраненного мероприятия соответствует ранее введенному")
    @Test(dependsOnMethods = "clickButtonSave")
    public void checkNameEvent() {
        calendarPageHelper.checkNameEvent();
    }

    @Title("Удаляем мероприятие из календаря")
    @Test(dependsOnMethods = "checkNameEvent")
    public void deleteEvent() {
        calendarPageHelper.removeEventFromCalendar();
    }

    @Title("Логаут")
    @Test(dependsOnMethods = "deleteEvent")
    public void logout() {
        loginPageHelper.logout();
    }

    @Title("Грохаем браузер")
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

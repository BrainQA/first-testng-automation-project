package google.ru.googleTests.pages;

import google.ru.googleTests.basePage.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalendarPage extends BaseSetup {

    private WebDriverWait wait;
    private Actions actions;


    public CalendarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }

    //Приложение Календарь
    @FindBy(xpath = "//*[@id='ogbkddg:8']")
    protected WebElement appCalendar;

    //Ждем загрузки приложения Календарь
    protected void waitAppCalendar() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='ogbkddg:8']")));
    }
    //Кнопка ОК на всплывающем окне
    @FindBy(xpath = "//div[@class='O0WRkf zZhnYe e3Duub C0oVfc M9Bg4d']")
    protected WebElement buttonOK;

    //Кнопка Создать мероприятие
    @FindBy(xpath = "//content[@class='Ip8zfc']")
    protected WebElement createEvent;

    //Поле Добавить название
    @FindBy(xpath = "//input[@id='xTiIn']")
    protected WebElement fieldAddName;

    //Поле Дата начала
    @FindBy(xpath = "//div[@class='Kb2sf QGLPie nXeosb t4IwDf CDELXb']")
    protected WebElement fieldStartDate;

    //CheckBox Весь день
    @FindBy(xpath = "//div[@id='xAlDaCbx' and @role='checkbox']")
    protected WebElement checkBoxAllDay;

    //Список периодичности мероприятия
    @FindBy(xpath = "//div[@class='e2CuFe eU809d']")
    protected WebElement listPeriodicityEvent;

    //Мероприятие Ежедневно
    @FindBy(xpath = "//*[@id=\"YPCqFe\"]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/content")
    protected WebElement eventDaily;

    //Периодичность мероприя Ежедневно из выпадающего списка
    protected void choosePeriodicityDaily() {
        WebElement periodicityEvent = driver.findElement(By.xpath("//div[@class='e2CuFe eU809d']"));
        WebElement periodicityEventDaily = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/content"));
        actions.moveToElement(periodicityEvent).moveToElement(periodicityEventDaily).click().build().perform();
    }

    //Поле Укажите место проведения
    @FindBy(xpath = "//*[@id=\"xLocIn\"]/div/content/div/div[1]/div[2]/div[1]/div/div[1]/input")
    protected WebElement fieldPlaceLocation;

    //Кнопка Добавить видеоконференцию
    @FindBy(xpath = ".//span[@class='NlWrkb']")
    protected WebElement listAddVideoconference;

    //Видеоконференция Hangouts
    @FindBy(xpath = "//div[@class='zqIikb' and text()='Hangouts']")
    protected WebElement videoconferenceHangouts;

    //Кнопка добавить уведомление
    @FindBy(xpath = "//span[@class='RveJvd snByac' or text()='Добавить уведомление']")
    protected WebElement buttonAddNotification;

    //Ждем загрузки кнопки Удалить уведомление
    protected void waitLoadedButtonDeleteNotification() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='xjKiLb']")));
    }

    //Кнопка удалить уведомление
    @FindBy(xpath = "//*[@class='xjKiLb']")
    protected WebElement buttonDeleteNotification;

    //Поле c email
    @FindBy(xpath = "//*[@id='xCalOwn']")
    protected WebElement fieldWithEmail;

    //Файл на Google Диске
    @FindBy(xpath = "//*[@class='pj-Ll-Vk-O-Kc']")
    protected WebElement fileOnGoogleDisk;

    //Кнопка Выбрать на окне Google диска
    @FindBy(xpath = "//*[@class='a-b-c d-u d-u-F Io-tb-hp-enabled']")
    protected WebElement buttonChoose;

    //Кнопка Отмена на окне Google диска
    @FindBy(xpath = "//*[@class='a-b-c d-u d-u-Q d-u-v']")
    protected WebElement buttonCancel;

    protected void waitLoadedPageGoogleDisk() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(":1e")));
    }

    //Кнопка Выбранные ранее на странице Выберите файл
    @FindBy(id = ":1e")
    protected WebElement buttonPreviouslySelected;

    //Кнопка Прикрепить файл
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[1]/div/content/span")
    protected WebElement buttonAttachFile;

    //Кнопка Полужирный
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[3]/content/span")
    protected WebElement buttonBold;

    //Кнопка Курсив
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[4]/content/span")
    protected WebElement buttonCurcive;

    //Кнопка Подчеркнутый
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[5]/content/span")
    protected WebElement buttonUnderLine;

    //Кнопка Нумерованный список
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[7]/content/span")
    protected WebElement buttonNumberedList;

    //Маркированный список
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[8]/content/span")
    protected WebElement buttonMarkedList;

    //Ссылка
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[10]/content/span")
    protected WebElement buttonLink;

    //Удалить форматирование
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[11]/content/span")
    protected WebElement buttonRemoveFormatting;

    //Поле Описание
    @FindBy(xpath = "//div[@id='xDescIn' or @class='Sz0nN b4sm0d']")
    protected WebElement fieldDescription;

    //Кнопка Сохранить
    @FindBy(xpath = "//div[@id='xSaveBu']")
    protected WebElement buttonSave;

    //Поле мероприятие в календаре
    @FindBy(xpath = "//div[@class='jRJqje sMVRZe']")
    protected WebElement eventNameInCalendar;

    //Кнопка удалить Мероприятие
    @FindBy(xpath = "//*[@id=\"xDetDlgDelBu\"]/content/span")
    protected WebElement buttonDeleteEvent;

    protected void waitLoadedButtonDeleteEvent() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='jO7h3c' or text()='Удалить']")));
    }

    //Кнопка Удалить мероприятие из календаря
    @FindBy(xpath = "//div[@class='jO7h3c' or text()='Удалить']")
    protected WebElement buttonDeleteEventFromCalendar;
}
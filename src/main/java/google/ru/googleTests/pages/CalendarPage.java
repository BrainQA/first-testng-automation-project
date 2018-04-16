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
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;

import java.awt.*;


//@PageEntry(title = "")
public class CalendarPage extends BaseSetup {

    private WebDriverWait wait;
    private Actions actions;


    public CalendarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }

    @ElementTitle(value = "Приложение Календарь")
    @FindBy(xpath = "//*[@id='ogbkddg:8']")
    private WebElement appCalendar;

    //Ждем загрузки приложения Календарь
    protected void waitAppCalendar() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='ogbkddg:8']")));
    }

    @ElementTitle(value = "Кнопка ОК на всплывающем окне")
    @FindBy(xpath = "//div[@class='O0WRkf zZhnYe e3Duub C0oVfc M9Bg4d']")
    private WebElement buttonOK;

    @ElementTitle(value = "Кнопка Создать мероприятие")
    @FindBy(xpath = "//content[@class='Ip8zfc']")
    private WebElement createEvent;

    @ElementTitle(value = "Текстовое поле Добавить название")
    @FindBy(xpath = "//input[@id='xTiIn']")
    public WebElement fieldAddName;

    @ElementTitle(value = "Текстовое поле Дата начала")
    @FindBy(xpath = "//div[@class='Kb2sf QGLPie nXeosb t4IwDf CDELXb']")
    private WebElement fieldStartDate;

    @ElementTitle(value = "CheckBox Весь день")
    @FindBy(xpath = "//div[@id='xAlDaCbx' and @role='checkbox']")
    private WebElement checkBoxAllDay;

    @ElementTitle(value = "Список периодичности мероприятия")
    @FindBy(xpath = "//div[@class='e2CuFe eU809d']")
    private WebElement listPeriodicityEvent;

    @ElementTitle(value = "Мероприятие Ежедневно")
    @FindBy(xpath = "//*[@id=\"YPCqFe\"]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/content")
    private WebElement eventDaily;

    //Периодичность мероприя Ежедневно из выпадающего списка
    protected void choosePeriodicityDaily() {
        WebElement periodicityEvent = driver.findElement(By.xpath("//div[@class='e2CuFe eU809d']"));
        WebElement periodicityEventDaily = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/content"));
        actions.moveToElement(periodicityEvent).moveToElement(periodicityEventDaily).click().build().perform();
    }

    @ElementTitle(value = "Поле Укажите место проведения")
    @FindBy(xpath = "//*[@id=\"xLocIn\"]/div/content/div/div[1]/div[2]/div[1]/div/div[1]/input")
    private String fieldPlaceLocation;

    @ElementTitle(value = "Кнопка Добавить видеоконференцию")
    @FindBy(xpath = ".//span[@class='NlWrkb']")
    private WebElement buttonAddVideoconference;

    @ElementTitle(value = "Видеоконференция Hangouts")
    @FindBy(xpath = "//div[@class='zqIikb' and text()='Hangouts']")
    private WebElement videoconferenceHangouts;

    @ElementTitle(value = "Кнопка добавить уведомление")
    @FindBy(xpath = "//span[@class='RveJvd snByac' or text()='Добавить уведомление']")
    private WebElement buttonAddNotification;

    //Ждем загрузки кнопки Удалить уведомление
    private void waitLoadedButtonDeleteNotification() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='xjKiLb']")));
    }

    @ElementTitle(value = "Кнопка удалить уведомление")
    @FindBy(xpath = "//*[@class='xjKiLb']")
    private WebElement buttonDeleteNotification;

    @ElementTitle(value = "Поле c email")
    @FindBy(xpath = "//*[@id='xCalOwn']")
    private WebElement fieldWithEmail;

    @ElementTitle(value = "Файл на Google Диске")
    @FindBy(xpath = "//*[@class='pj-Ll-Vk-O-Kc']")
    private WebElement fileOnGoogleDisk;

    @ElementTitle(value = "Кнопка Выбрать на окне Google диска")
    @FindBy(xpath = "//*[@class='a-b-c d-u d-u-F Io-tb-hp-enabled']")
    private WebElement buttonChoose;

    @ElementTitle(value = "Кнопка Отмена на окне Google диска")
    @FindBy(xpath = "//*[@class='a-b-c d-u d-u-Q d-u-v']")
    private WebElement buttonCancel;

    protected void waitLoadedPageGoogleDisk() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(":1e")));
    }

    @ElementTitle(value = "Кнопка Выбранные ранее на странице Выберите файл")
    @FindBy(id = ":1e")
    private WebElement buttonPreviouslySelected;

    @ElementTitle(value = "Кнопка Прикрепить файл")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[1]/div/content/span")
    private WebElement buttonAttachFile;

    @ElementTitle(value = "Кнопка Полужирный")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[3]/content/span")
    private WebElement buttonBold;

    @ElementTitle(value = "Кнопка Курсив")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[4]/content/span")
    private WebElement buttonCursive;

    @ElementTitle(value = "Кнопка Подчеркнутый")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[5]/content/span")
    private WebElement buttonUnderLine;

    @ElementTitle(value = "Кнопка Нумерованный список")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[7]/content/span")
    private WebElement buttonNumberedList;

    @ElementTitle(value = "Маркированный список")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[8]/content/span")
    private WebElement buttonMarkedList;

    @ElementTitle(value = "Ссылка")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[10]/content/span")
    private WebElement buttonLink;

    @ElementTitle(value = "Удалить форматирование")
    @FindBy(xpath = "//*[@id=\"xDesc\"]/div[1]/div[1]/div[11]/content/span")
    private WebElement buttonRemoveFormatting;

    @ElementTitle(value = "Поле Описание")
    @FindBy(xpath = "//div[@id='xDescIn' or @class='Sz0nN b4sm0d']")
    private WebElement fieldDescription;

    @ElementTitle(value = "Кнопка Сохранить")
    @FindBy(xpath = "//div[@id='xSaveBu']")
    private WebElement buttonSave;

    @ElementTitle(value = "Поле мероприятие в календаре")
    @FindBy(xpath = "//div[@class='jRJqje sMVRZe']")
    private WebElement eventNameInCalendar;

    @ElementTitle(value = "Кнопка удалить Мероприятие")
    @FindBy(xpath = "//*[@id=\"xDetDlgDelBu\"]/content/span")
    private WebElement buttonDeleteEvent;

    protected void waitLoadedButtonDeleteEvent() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='jO7h3c' or text()='Удалить']")));
    }

    @ElementTitle(value = "Кнопка Удалить мероприятие из календаря")
    @FindBy(xpath = "//div[@class='jO7h3c' or text()='Удалить']")
    private WebElement buttonDeleteEventFromCalendar;

    public WebElement getAppCalendar() {
        return appCalendar;
    }

    public WebElement getButtonOK() {
        return buttonOK;
    }

    public  WebElement getCreateEvent() {
        return createEvent;
    }

    public WebElement getFieldAddName() {
        return fieldAddName;
    }

    public void setFieldAddName(WebElement fieldAddName) {
        this.fieldAddName = fieldAddName;
    }

    public WebElement getFieldStartDate() {
        return fieldStartDate;
    }

    public WebElement getCheckBoxAllDay() {
        return checkBoxAllDay;
    }

    public WebElement getListPeriodicityEvent() {
        return listPeriodicityEvent;
    }

    public WebElement getEventDaily() {
        return eventDaily;
    }

    public String getFieldPlaceLocation() {
        return fieldPlaceLocation;
    }

    public void setFieldPlaceLocation(String fieldPlaceLocation) {
        this.fieldPlaceLocation = fieldPlaceLocation;
    }

    public WebElement getButtonAddVideoconference() {
        return buttonAddVideoconference;
    }

    public WebElement getFieldDescription() {
        return fieldDescription;
    }

    public WebElement getButtonAddNotification() {
        return buttonAddNotification;
    }

    public WebElement getButtonAttachFile() {
        return buttonAttachFile;
    }

    public WebElement getButtonBold() {
        return buttonBold;
    }

    public WebElement getButtonCancel() {
        return buttonCancel;
    }

    public WebElement getButtonChoose() {
        return buttonChoose;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebElement getButtonCursive() {
        return buttonCursive;
    }

    public WebElement getEventNameInCalendar() {
        return eventNameInCalendar;
    }

    public WebElement getFieldWithEmail() {
        return fieldWithEmail;
    }

    public WebElement getButtonDeleteEvent() {
        return buttonDeleteEvent;
    }

    public WebElement getButtonDeleteEventFromCalendar() {
        return buttonDeleteEventFromCalendar;
    }

    public WebElement getButtonDeleteNotification() {
        return buttonDeleteNotification;
    }

    public WebElement getButtonLink() {
        return buttonLink;
    }

    public WebElement getButtonMarkedList() {
        return buttonMarkedList;
    }

    public WebElement getButtonNumberedList() {
        return buttonNumberedList;
    }

    public WebElement getButtonPreviouslySelected() {
        return buttonPreviouslySelected;
    }

    public WebElement getButtonRemoveFormatting() {
        return buttonRemoveFormatting;
    }

    public WebElement getButtonSave() {
        return buttonSave;
    }

    public WebElement getButtonUnderLine() {
        return buttonUnderLine;
    }

    public WebElement getFileOnGoogleDisk() {
        return fileOnGoogleDisk;
    }

    public WebElement getVideoconferenceHangouts() {
        return videoconferenceHangouts;
    }
}
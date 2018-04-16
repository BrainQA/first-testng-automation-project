package google.ru.googleTests.testsLogic;

import google.ru.googleTests.pages.CalendarPage;
import jnr.ffi.Struct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.Formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CalendarPageHelper extends CalendarPage {

    private Actions actions;
    //private TextField fieldAddName;
    private TextField getFieldDescription;

    public CalendarPageHelper(WebDriver driver) {
        super(driver);
    }

    //Кликаем на значок приложения Календарь
    public void clickAppCalendar() {
        waitAppCalendar();
        getAppCalendar().click();
    }

    //Кликаем по Кнопке ОК на всплывающем окне
    public void clickButtonOK() {
        getButtonOK().click();
    }

    //Кликаем по кннопке Создать мероприятие
    public void clickButtonCreateEvent() throws InterruptedException {
        getCreateEvent().click();
    }

    //В поле Добавить название вставляем название мероприятия
    public void inputNameEvent(String nameEvent) {
        setFieldAddName(fieldAddName);
    }

    //Проверяем, что текущая дата соответствует дате начала мероприятия
    public void checkDateStartEvent() {
        getFieldStartDate().getText();
    }

    //Проверяем доступность чек бокса Весь деньe, если доступен, то проставляем
    public void verifyCheckBoxAndClick() {
        getCheckBoxAllDay().isSelected();
        getCheckBoxAllDay().click();
    }

    //Проверяем доступность поля Периодичность и выбираем Ежедневно
    public void choosePeriodicityEventDaily() throws InterruptedException {
        getListPeriodicityEvent().isEnabled();
        getListPeriodicityEvent().click();
        choosePeriodicityDaily();
    }

    //Проверяем доступность поля Укажите место проведения
    public void inputPlaceLocation(String placeLocation) {
        getFieldPlaceLocation().isEmpty();
        //setFieldPlaceLocation().click;
    }

    //Проверяем доступность кнопки Добавить видеоконференцию
    public void checkButtonAddVideoConference() {
        getButtonAddVideoconference().isEnabled();
    }

    //Проверяем доступность кнопки Добавить уведомление
    public void checkButtonAddNotification() {
        getButtonAddNotification().isEnabled();
    }

    //Проверяем, что поле с email соответствует аккаунту
    public void checkAccordanceEmail(String email) {
        String fieldEmail = getFieldWithEmail().getText();
        assertEquals(email, fieldEmail);
        System.out.println("Cовпадение email: " + fieldEmail);
    }

    //Создаем файл .txt
    public void createFileTxt() {
        try {
            Formatter formatter = new Formatter("C:\\Java\\I'm learn Selenium + Java");
            formatter.format("%s %s %s %s", "I", "like", "learn", "Java");
            formatter.close();
        } catch (Exception e) {
            System.out.println("Error create file");
        }
    }

    //Прикрепляем файл к мероприятию
    public void attachFileForEvent() throws InterruptedException {
        getButtonAttachFile().click();
        waitLoadedPageGoogleDisk();
        getButtonChoose().isEnabled();
        getButtonCancel().isEnabled();
        getButtonPreviouslySelected().click();
    }

    //Проверяем доступность кнопок в поле Описание
    public void checkButtonFieldDescription() {
        getButtonAttachFile().isEnabled();
        getButtonBold().isEnabled();
        getButtonCursive().isEnabled();
        getButtonUnderLine().isEnabled();
        getButtonNumberedList().isEnabled();
        getButtonMarkedList().isEnabled();
        getButtonLink().isEnabled();
        getButtonRemoveFormatting().isEnabled();
    }

    //Проверяем поле Описание и вводим текст
    public void checkFieldDescriptionAndInputText() {
        if (getFieldDescription().isEnabled()) {
        getFieldDescription.setText("I like to learn Java!"); }
        else {
            System.out.println("Поле 'Описание' не доступно для редактирования");
        }
    }

    //Нажимаем кнопку Сохранить
    public void clickButtonSave(){
        getButtonSave().click();
    }

    //Проверяем, что мероприятие сохранилось под введенным ранее именем
    public void checkNameEvent(String nameEvent) {
        assertNotNull(getEventNameInCalendar());
    }

    //Удаляем мероприятие из календаря
    public void deleteEvent(){
        getEventNameInCalendar().click();
        getButtonDeleteEvent().click();
    }

    //Удаляем мероприятие из календаря
    public void removeEventFromCalendar() {
        actions.moveToElement(getEventNameInCalendar()).perform();
        actions.contextClick().perform();
        waitLoadedButtonDeleteEvent();
        getButtonDeleteEventFromCalendar().click();
    }
}


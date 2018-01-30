package google.ru.googleTests.testsLogic;

import google.ru.googleTests.pages.CalendarPage;
import org.openqa.selenium.WebDriver;

import java.util.Formatter;
import org.junit.Assume;

import static org.junit.Assume.*;


public class CalendarPageHelper extends CalendarPage {

    public CalendarPageHelper(WebDriver driver) {
        super(driver);
    }

    //Кликаем на значок приложения Календарь
    public void clickAppCalendar() {
        appCalendar.click();
    }

    //Кликаем по Кнопке ОК на всплывающем окне
    public void clickButtonOK() {
        buttonOK.click();
    }

    //Кликаем по кннопке Создать мероприятие
    public void clickButtonCreateEvent() throws InterruptedException {
        createEvent.click();
    }

    //В поле Добавить название вставляем название мероприятия
    public void inputNameEvent(String nameEvent) {
        fieldAddName.sendKeys(nameEvent);
    }

    //Проверяем, что текущая дата соответствует дате начала мероприятия
    public void checkDateStartEvent() {
        fieldStartDate.getText();
    }

    //Проверяем доступность чек бокса Весь день, если доступен, то проставляем
    public void verifyCheckBoxAndClick() {
        checkBoxAllDay.isSelected();
        checkBoxAllDay.click();
    }

    //Проверяем доступность поля Периодичность и выбираем Ежедневно
    public void choosePeriodicityEventDaily() throws InterruptedException {
        listPeriodicityEvent.isEnabled();
        listPeriodicityEvent.click();
        choosePeriodicityDaily();
        //Thread.sleep(2000);
    }

    //Проверяем доступность поля Укажите место проведения
    public void inputPlaceLocation(String placeLocation) throws InterruptedException {
        fieldPlaceLocation.isEnabled();
        fieldPlaceLocation.sendKeys(placeLocation);
        //Thread.sleep(1000);
    }

    //Проверяем доступность кнопки Добавить видеоконференцию
    public void checkButtonAddVideoConference() {
        listAddVideoconference.isEnabled();
    }

    //Проверяем доступность кнопки Добавить уведомление
    public void checkButtonAddNotification() {
        buttonAddNotification.isEnabled();
    }

    //Проверяем, что поле с email соответствует аккаунту
    public void checkAccordanceEmail(String email) {
        String fieldEmail = String.valueOf(fieldWithEmail.getText().equals(email));
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
        buttonAttachFile.click();
        waitLoadedPageGoogleDisk();
        buttonChoose.isEnabled();
        buttonCancel.isEnabled();
        buttonPreviouslySelected.click();
    }

    //Проверяем поле Описание и вводим текст
    public void checkFieldDescriptionAndInputText(String textDescription) {
        fieldDescription.isSelected();
        fieldDescription.sendKeys(textDescription);
    }

    //Нажимаем кнопку Сохранить
    public void clickButtonSave(){
        buttonSave.click();
    }

    //Проверяем, что мероприятие сохранилось под введенным ранее именем
    public void checkNameEvent() {
        fieldEventNameInCalendar();
    }

    //Удаляем мероприятие из календаря
    public void removeEventFromCalendar() {
        actions.moveToElement(eventNameInCalendar).perform();
        actions.contextClick().perform();
        waitLoadedButtonDeleteEvent();
        buttonDeleteEventFromCalendar.click();
    }
}


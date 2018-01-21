package ru.yandexTests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Experement extends AnyPage {

    public Experement(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = ".//a[text()='Маркет']")
    private WebElement marketLink;

    public MainPage clickMainPage() {
        marketLink.click();
        return pages.mainPage;
    }
}

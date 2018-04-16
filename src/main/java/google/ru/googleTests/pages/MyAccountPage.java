package google.ru.googleTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;

public class MyAccountPage {

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @ElementTitle(value = "Тайтл страницы Защиты аккаунта")
    @FindBy(xpath = ("//div[@class='N4lOwd']"))
    protected WebElement pageProtect;

    public WebElement getPageProtect() {
        return pageProtect;
    }
}

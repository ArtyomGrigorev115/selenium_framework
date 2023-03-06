package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public abstract class BasePage {

    //*Вебдрайвер доступный на всех страницах
    WebDriver driver;

    public BasePage() {
        this.driver = BaseTest.getDriver();

        /*ленивая инициализация элементов на странце*/
        PageFactory.initElements(driver, this);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public abstract class BasePage {

    //*Вебдрайвер доступный на всех страницах
    WebDriver driver;

    public BasePage() {
        this.driver = BaseTest.getDriver();
    }
}

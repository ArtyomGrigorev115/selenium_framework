package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*Дейстаия, которые можно выполнить на странице*/
public class Task1Page extends BasePage {

    private By f1 = By.tagName("input");
    private By f2 = By.name("last_name");
    private By f3 = By.className("city");
    private By f4 = By.id("country");
    private By b = By.cssSelector("button.btn");

    public Task1Page() {
        super();
    }

    public void fillRequiredField(){
        WebElement fName = driver.findElement(f1);
        WebElement fLastName = driver.findElement(f2);
        WebElement fCity = driver.findElement(f3);
        WebElement fCountry = driver.findElement(f4);

        fName.sendKeys("Ivan");
        fLastName.sendKeys("Petrov");
        fCity.sendKeys("Smolensk");
        fCountry.sendKeys("Russia");

    }

    public void buttonClick(){
        WebElement button = driver.findElement(b);
        button.click();
    }


}

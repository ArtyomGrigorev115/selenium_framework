package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Страница, на которой можно
 * производить поиск по тексту
 */
public class SearchPage extends BasePage{

    /*
    * сразу объявление элемента и поиск по локатору
    * без lazy инициализации в  PageFactory фабрике это будет null*/
    @FindBy(name = "q")
    private WebElement searchField;

   // private By searchField = By.name("q"); //? типа ленивая инициализация
    //WebElement searchField = driver.findElement(By.name("q"));

    public SearchPage() {
        super(); //? инициализация ведрайвера
    }

    /*Необходимые действия на странице*/
    public void fillSearchField(String text){
        /*WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.click();
        searchFieldElement.sendKeys(text);*/

        searchField.click();
        searchField.sendKeys(text);
    }

    public void pressEnter(){
        /*WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.sendKeys(Keys.RETURN);*/

        searchField.sendKeys(Keys.RETURN);
    }
}

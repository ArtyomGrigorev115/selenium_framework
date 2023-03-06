package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница с результатами поиска
 */
public class SearchResultPage extends BasePage{

    private By resultRow = By.xpath("//div[@class='g']//h3");

    public SearchResultPage() {
        super();
    }

    /*Проверяет содержание текста в первом из результатов поиска*/
    public void assertThatTopResultContainsCorrectText(String expected){

        WebElement resultRowElement = driver.findElement(resultRow);

        Assertions.assertThat(resultRowElement.isDisplayed())
                .as("Элемент не виден не экране").isTrue();
        Assertions.assertThat(resultRowElement.getText())
                .as("В ЭЛЕМЕНТЕ НЕ ТОТ ТЕКСТ")
                .isEqualTo(expected);
    }

    /*Проверяет атрибуты класса*/
    public void assertThatTopResultContainsProperAttributeText(String expected){

        WebElement resultRowElement = driver.findElement(resultRow);

        Assertions.assertThat(resultRowElement.getAttribute("class"))
                .as("НЕ ТОТ КЛАСС").contains(expected);
    }
}

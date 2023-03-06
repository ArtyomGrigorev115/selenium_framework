package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchTest extends BaseTest {
//    private WebDriver driver;

    //отработает один раз для всего класса
   /* @BeforeClass
   * public void setUp(){
   *    File file = new File("E:\\project\\testing\\test_framework\\src\\test\\resources\\msedgedriver.exe");
   *     System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
   *     driver = new EdgeDriver();
   *    driver.get("https://www.google.com");
    }*/

    //Вызовится после прохождения всех тестов
   /* @AfterClass
    public void tearDown(){
       driver.quit();
    }*/

    /*ВЫполняется после завершения каждого теста.*/
   /* @AfterMethod
    public void goBack(){
        driver.navigate().back();
    }*/

    /*Можно испольщовать аннотации @BeforeMethod и @AfterMethod во всеъ тестах, которые будут выполнятся перед и после кадого тестового метода*/
//    @BeforeMethod
//    public void setUp(){
//        File file = new File("E:\\project\\testing\\test_framework\\src\\test\\resources\\msedgedriver.exe");
//        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
//        driver = new EdgeDriver();
//        driver.get("https://www.google.com");
//    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }


    @Test
    public void openGoogleComInEdgeTest1() throws InterruptedException {
      /*  WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys("selenium java");
        searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement resRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        System.out.println(resRow);

        Assertions.assertThat(resRow.isDisplayed())
                .as("Элемент не виден не экране").isTrue();
        Assertions.assertThat(resRow.getText())
                .as("В ЭЛЕМЕНТЕ НЕ ТОТ ТЕКСТ")
                .isEqualTo("The Selenium Browser Automation Project");

        Assertions.assertThat(resRow.getAttribute("class"))
                .as("НЕ ТОТ КЛАСС").contains("LC20lb");*/

        /*Что бы воспользоваться дейсвиями, которое необходимы для тестирования, нужно создать
        * инстанс нужной стрицы*/



    }

    @Test
    public void openGoogleComInEdgeTest2() throws InterruptedException {
    /*    WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys("selenium java");
        searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement resRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        System.out.println(resRow);

        Assertions.assertThat(resRow.isDisplayed())
                .as("Элемент не виден не экране").isTrue();
        Assertions.assertThat(resRow.getText())
                .as("В ЭЛЕМЕНТЕ НЕ ТОТ ТЕКСТ")
                .isEqualTo("The Selenium Browser Automation Project");

        Assertions.assertThat(resRow.getAttribute("class"))
                .as("НЕ ТОТ КЛАСС").contains("LC20lb");*/

    }

    @Test(dataProvider = "dataProvider")
    public void openGoogleComInEdgeTest3(String text) throws InterruptedException {
     /*   WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement resRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        System.out.println(resRow);

        Assertions.assertThat(resRow.isDisplayed())
                .as("Элемент не виден не экране").isTrue();
        Assertions.assertThat(resRow.getText())
                .as("В ЭЛЕМЕНТЕ НЕ ТОТ ТЕКСТ")
                .isEqualTo("The Selenium Browser Automation Project");

        Assertions.assertThat(resRow.getAttribute("class"))
                .as("НЕ ТОТ КЛАСС").contains("LC20lb");*/

        /*Что бы воспользоваться дейсвиями, которое необходимы для тестирования, нужно создать
         * инстанс нужной стрицы*/
        SearchPage searchPage = new SearchPage();
        searchPage.fillSearchField(text);
        searchPage.pressEnter();

        Thread.sleep(3000);

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.assertThatTopResultContainsCorrectText("The Selenium Browser Automation Project");
        searchResultPage.assertThatTopResultContainsProperAttributeText("LC20lb");


       /*
               Эта логика инкапсулирована в SearchResultsPage
       WebElement resRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        Assertions.assertThat(resRow.isDisplayed())
                .as("Элемент не виден не экране").isTrue();
        Assertions.assertThat(resRow.getText())
                .as("В ЭЛЕМЕНТЕ НЕ ТОТ ТЕКСТ")
                .isEqualTo("The Selenium Browser Automation Project");

        Assertions.assertThat(resRow.getAttribute("class"))
                .as("НЕ ТОТ КЛАСС").contains("LC20lb");*/

    }


}

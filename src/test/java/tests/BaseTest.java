package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;
import utils.PropertyReader;

import java.io.File;
import java.util.Objects;

public abstract class BaseTest {
    private static WebDriver driver;
    //начальный шаг, с которово начинаются тесты
    SearchSteps steps;


    public static WebDriver getDriver() {
        return driver;
    }

    //отработает один раз для всего класса
    @BeforeClass
    public void setUp() {

       // driver = DriverFactory.getDriver(Browser.EDGE);
       // driver.get("https://www.google.com");

        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getUrl());

        steps = new SearchSteps(); //начало выполнения теста
    }

    //Вызовится после прохождения всех тестов
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /*ВЫполняется после завершения каждого теста.*/
    @AfterMethod
    public void goBack() throws InterruptedException {
        driver.navigate().back();
      //  driver.wait(3000);
    }

    /*Передача тестовых данных для тестированя
     * запустит несколько тестов в зависимости от числа элементов в массиве
     * каждый элемент массива будет аргуменом метода
     */
    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
    }
}

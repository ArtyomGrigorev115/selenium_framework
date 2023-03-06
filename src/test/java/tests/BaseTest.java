package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Objects;

public abstract class BaseTest {

    private static WebDriver driver;

    //? Геттер для ведрайвера
    public static WebDriver getDriver() {
        return driver;
    }

    //отработает один раз для всего класса
    @BeforeClass
    public void setUp() {
        File file = new File("E:\\project\\testing\\test_framework\\src\\test\\resources\\msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        driver = new EdgeDriver();
        driver.get("https://www.google.com");
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

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumCommansTest {
    private final static String DRIVER_PATH = "E:\\project\\testing\\test_framework\\selenium_and_selenide\\src\\test\\resources\\";
    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.out.println("Before All init() method called");
        File file;
        file = new File(DRIVER_PATH +  "msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        driver = new EdgeDriver();
    }

    @Test
    public void testSearchGoogle() throws InterruptedException {



        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("ChromeDriver");
        // driver.wait(2000);
        searchField.submit();
        driver.quit();
    }

    @Test
    public void pageActionsTest() throws InterruptedException {
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("ChromeDriver");
        searchField.submit();
       // driver.wait(5000);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }

    @Test
    public void elementpropertiesTest(){
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.name("q"));

        System.out.println(searchField.getSize().toString());
        System.out.println(searchField.getTagName());
        System.out.println(searchField.getAttribute("ariaLabel"));
    }

    @Test
    public void jsCodeExecutionTest(){
        driver.get("https://google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("""
function sum(a, b){
return a + b;
}
alert(sum(10,20))
""");
    }
}

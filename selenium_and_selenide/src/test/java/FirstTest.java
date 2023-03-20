import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class FirstTest {

    private final static String DRIVER_PATH = "E:\\project\\testing\\test_framework\\selenium_and_selenide\\src\\test\\resources\\";

    @Test
    public void testSearchGoogle() throws InterruptedException {
        WebDriver driver;
        File file;
        file = new File(DRIVER_PATH +  "msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        driver = new EdgeDriver();

        driver.get("https://google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("ChromeDriver");
       // driver.wait(2000);
        searchField.submit();
        driver.quit();
    }

}

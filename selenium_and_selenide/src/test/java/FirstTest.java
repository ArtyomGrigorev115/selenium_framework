import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class FirstTest {

    private final static String DRIVER_PATH = "E:\\project\\testing\\test_framework\\selenium_and_selenide\\src\\test\\resources\\msedgedriver.exe";

    @Test
    public void testSearchGoogle(){
        WebDriver driver;
        File file;
        file = new File(DRIVER_PATH +  "msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        driver = new EdgeDriver();

        driver.get("https://google.com");
    }

}

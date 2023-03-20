package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class DriverFactory {
    private static WebDriver driver;
    private final static String DRIVER_PATH = "E:\\project\\testing\\test_framework\\src\\test\\resources\\";

    public static WebDriver getDriver(Browser browser){
        File file;
        switch (browser){
            case EDGE -> {
                file = new File(DRIVER_PATH +  "msedgedriver.exe");
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
            }

        }
      //  driver.manage().window().maximize(); // ?можно
        return driver;
    }
}



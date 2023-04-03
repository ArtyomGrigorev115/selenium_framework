package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class SeleniumMainMethods {
    private final static String DRIVER_PATH = "E:\\project\\testing\\test_framework\\selenium_and_selenide\\src\\test\\resources\\";
    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.out.println("Before All init() method called");
        File file;
        file = new File(DRIVER_PATH +  "msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
      //  driver = new EdgeDriver(); toDO: инициализировать в методе
    }

    @Test
    public void webdriverMethodManage(){
        driver.get("https://google.com");

        WebDriver.Options options =  driver.manage();
        Method[] iOptions =  options.getClass().getMethods();

        Arrays.stream(iOptions).forEach(SeleniumMainMethods::showManageMethod);
    }

    @Test
    public void webDriverGetAndNavigateMethod(){
        //Загружает страницу по URL. Ждёт полной загрузки страницы. прежде чем вернуть упарвление
        // сценарию
       // driver.get("https://google.com");

        /*Не ждёт загрузки всей страницы*/
        driver.navigate().to("https://google.com");
    }

    @Test
    public void getWindowHandle(){
        driver.get("https://google.com");

        /*Дескриптор текущего открытого окна, который уникально идентифицирует окно
         * для этого экземпляра драйвера*/
        var driverWindowDescriptor = driver.getWindowHandle();
        System.out.printf("window1 -> %s\n", driverWindowDescriptor);


          WebDriver driver2 = new EdgeDriver();
          driver2.get("https://www.yahoo.com/");
          String driver2WindowDescriptor = driver2.getWindowHandle();
          System.out.printf("window2 -> %s", driver2WindowDescriptor);





    }
    
    @Test
    public void getWindowHandlesMethodTest(){
         /* driver.getWindowHandles()
         возвращает набор дескрипторов окон данного экземпляра вебдрайвера*/
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://google.com");

        Set<String> oldWindow = webDriver.getWindowHandles();
        System.out.println("oldWindow ->" + oldWindow);

        ((JavascriptExecutor)webDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());

        webDriver.switchTo().window(tabs.get(1));
        webDriver.get("https://www.yahoo.com/");

        Set<String> newWindow = webDriver.getWindowHandles();
        System.out.println("newWindow -> " + newWindow);

    }

    private static void showManageMethod(Method method){
        System.out.println("МЕТОД");
        System.out.println(method);
    }
}

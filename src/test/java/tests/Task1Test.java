package tests;

import org.testng.annotations.Test;
import pages.Task1Page;

public class Task1Test extends BaseTest{

    @Test
    public void task1Test(){
        Task1Page task1Page = new Task1Page();
        task1Page.fillRequiredField();
        task1Page.buttonClick();
    }
}

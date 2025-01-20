package PracticeMethods;

import BaseClass.baseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShots extends baseClass {
    @Test
    public void screenshot() throws InterruptedException {

        WebDriver diver = new ChromeDriver();
        diver.get("https://www.google.com/");
        Thread.sleep(3000);
        System.out.println(System.getProperty("user.dir"));
        TakesScreenshot tsk = (TakesScreenshot) driver;

          File srcFile = tsk.getScreenshotAs(OutputType.FILE);
          File disFile = new File(System.getProperty("user.dir")+"\\target\\ScreenShots\\fullPage.png");
          srcFile.renameTo(disFile);


          // Method2 group of eleemnts screenshots --> jsut get the xpath and pass it
        WebElement ele = diver.findElement();





    }



}

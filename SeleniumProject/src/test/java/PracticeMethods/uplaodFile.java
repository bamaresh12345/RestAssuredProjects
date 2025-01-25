package PracticeMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class uplaodFile {
/* use sendKeys method in selenium to uplaod a file
 get the path fo the file using system.getProperty(ser.dir)
 click on uplaod button
 check the h3 or h4 do we need verify upload succesfull message
 user Assert and very the uplaod successful message

 */

    @Test
    public void uplaodfile()
    {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String filePath = "C:\\Users\\bamar\\IdeaProjects\\PlaywriteProject\\SeleniumProject\\target\\resources\\config.properties";

        JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView",fileUplaod);

        WebElement fileUplaod = driver.findElement(By.xpath("//input[@id='file-upload']"));
        fileUplaod.sendKeys(filePath);
        //js.executeScript("arguments[0].scrollIntoView()",fileUplaod);

        driver.findElement(By.xpath("//input[@id='file-submit']")).click();


        String successfulMessage = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        Assert.assertEquals(successfulMessage,"config.properties");






    }
}

package practiceMethods2;

import BaseClass.baseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsExamples extends baseClass {

    @Test
    public void verify_AlertTest()
    {
       // WebDriver driver = new ChromeDriver();
        System.out.println("Test-->"+prop.getProperty("urlalerts"));
        driver.get(prop.getProperty("urlalerts"));

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

         WebElement ele = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));

         ele.click();

           Alert myAlerts = driver.switchTo().alert();
           myAlerts.accept();  //or
           //myAlerts.dismiss();






    }

}

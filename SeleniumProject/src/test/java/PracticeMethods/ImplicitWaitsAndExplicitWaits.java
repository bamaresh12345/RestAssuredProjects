package PracticeMethods;

import BaseClass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitsAndExplicitWaits extends baseClass {

/*
Implicit Wait in Selenium
1. Applies to all elements in a test script.
2. No need to specify “ExpectedConditions” on the element to be located
3	Most effective when used in a test case in which the elements are located with the time frame specified in implicit wait

Explicit Wait in Selenium
1. Applies only to specific elements as intended by the user.
2. Must always specify “ExpectedConditions” on the element to be located
3. Most effective when used when the elements are taking a long time to load. Also useful for verifying property of the element, such as visibilityOfElementLocated, elementToBeClickable, elementToBeSelected
 */

    @Test
    public void implicitWaits() {

        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("urlwait"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement ele = driver.findElement(By.xpath("//button[@class='dropbtn']"));

        // Scrolling down the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        //ElementNotInteractableException: element not interactable Expcetion is thrown if time is crossed
        driver.findElement(By.xpath("//a[text()='Facebook']")).click();
        String s = driver.getCurrentUrl();
        Assert.assertEquals(s,"https://www.facebook.com/");


    }

    @Test
    public void ExplictWaits() {
        /* Explicit wait, will use ExpectedConditions below are some of
            alertIsPresent()
            elementToBeClickable()
            elementToBeSelected()
            elementSelectionStateToBe()
            textToBePresentInElement()
            textToBePresentInElementLocated()
            textToBePresentInElementValue()
         */
        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("urlwait"));
        driver.manage().window().maximize();

        WebElement ele = driver.findElement(By.xpath("//button[@class='dropbtn']"));

        // Scrolling down the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));

        //TimeoutException: Expected condition failed: waiting for element to be clickable: By.xpath: //a[text()='Facebook']
        // (tried for 1 second(s) with 500 milliseconds interval) - if time is crossed
        WebElement ele2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Facebook']")));
        ele2.click();

        String s = driver.getCurrentUrl();
        Assert.assertEquals(s,"https://www.facebook.com/");


    }

    @Test
    public void ThreadSleep() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("urlwait"));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));   //Eception --> ElementNotInteractableException
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.findElement(By.className("dropbtn")).click();
        Thread.sleep(4000);

        WebElement ele =   driver.findElement(By.xpath("//a[text()='Facebook']"));
        ele.click();

        String s= driver.getCurrentUrl();
        Assert.assertEquals(s,"https://www.facebook.com/");

    }
}

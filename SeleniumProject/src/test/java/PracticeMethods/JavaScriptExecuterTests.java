package PracticeMethods;

import BaseClass.baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class JavaScriptExecuterTests extends baseClass {


    @Test
    public void testJavaScriptExecuter() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));

        //define the element
        WebElement nameBox = driver.findElement(By.xpath("//input[@id='name']"));
       // nameBox.sendKeys("Test");


        //define javaScriptExecuter
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //js.executeScript("argument[0].click()", nameBox); // check practiacaly error dont scare , onnly e is missing
        js.executeScript("arguments[0].click()", nameBox); // click on element
        Thread.sleep(2000);
        //set value into Name edit box
        js.executeScript("arguments[0].setAttribute('value','test')",nameBox);
        //js.executeScript("document.getElementbyId('idemail').value",nameBox);


        /*ScrollDown
         * 1. scroll down till end of the page
         * 2. scroll down till the webelement
         * 3. scroll down till end of the pixel
         */

        WebElement comboBox = driver.findElement(By.xpath("//input[@id='comboBox']"));

        //scroll to page till the webelement is visible
        js.executeScript("arguments[0].scrollIntoView()", comboBox);
        Thread.sleep(2000);


        //scroll till the given pixel
        js.executeScript("window.scrollBy(0,1500)","");

        //scroll till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        System.out.println(js.executeScript("return window.pageYOffset;")); // prints y axes=is 15


        Thread.sleep(2000);

        //scroll till inital of the page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");  // ,-document will reverse the scrolling

        System.out.println(js.executeScript("return window.pageYOffset;")); // prints y axes=is 15


        // Scroll vertical in page and reverse vertical in a page
        // js.executeScript("window.scrollBy(0,document.body.scrollWidth)");
        // js.executeScript("window.scrollBy(0,-document.body.scrollWidth)");






    }



}

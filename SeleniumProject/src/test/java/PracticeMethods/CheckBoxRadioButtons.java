package PracticeMethods;

import BaseClass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class CheckBoxRadioButtons extends baseClass {

    @Test(priority = 1)
    public void Validate_CheckBoxes() throws InterruptedException {
        System.out.println("url --> " + prop.getProperty("url"));
        String url = prop.getProperty("url");

        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement sundayCheckbox = driver.findElement(By.xpath("//input[@id='sunday']"));
        sundayCheckbox.click();

        SoftAssert sf = new SoftAssert();
        //  sf.assertFalse(sundayCheckbox.isDisplayed());
        // sf.assertFalse(sundayCheckbox.isEnabled());
        sf.assertTrue(sundayCheckbox.isSelected());


        List<WebElement> allCgheckBoxes = driver.findElements(By.xpath("//label[@class='form-check-label']"));

        // loop thru all checkbox webelements
        for (WebElement ele : allCgheckBoxes) {

            System.out.println(ele.getText());
            ele.click();
        }
        // check if checkbox is not checked then check it
        if (!sundayCheckbox.isSelected())  //sundayCheckbox.isSelected()==false
        {
            Thread.sleep(1000);
            sundayCheckbox.click();
            Thread.sleep(1000);
        }
        sf.assertAll(); // validates all assertions
    }

    @Test(priority = 2)
    public void Verify_RadioButtons() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        WebElement mailRadioButton = driver.findElement(By.xpath("//input[@type='radio']"));
        mailRadioButton.click();

        List<WebElement> allRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement radiobuttn : allRadioButtons)
        {
            Thread.sleep(1000);
            radiobuttn.click();
            Thread.sleep(1000);
        }

    }

}

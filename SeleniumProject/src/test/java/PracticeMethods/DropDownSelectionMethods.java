package PracticeMethods;

import BaseClass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownSelectionMethods extends baseClass
{

    @Test(priority=1)
    public void selectFromDropDownList() throws InterruptedException {

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

        // get the dropdown web element
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));

        // create select instnace and use all 3 methods
        Select conutryDropDown = new Select(dropdown);
        conutryDropDown.selectByVisibleText("India");
        Thread.sleep(1000);
        conutryDropDown.selectByIndex(3);
        Thread.sleep(1000);
        conutryDropDown.selectByValue("japan");  // ** IMP japan select from HTML value
        Thread.sleep(1000);

        // to check if its multi select
        System.out.println("is Dropdown is Multiselect dropdown or Single select dropdown"+conutryDropDown.isMultiple());

        //getOptions to get the text of all dropdown values
        List<WebElement> dropdownElements = conutryDropDown.getOptions();

        for (WebElement dropDownValue : dropdownElements)
        {
            System.out.println(dropDownValue.getText());
        }



        }


    @Test(priority=1)
    public void selectFromDropDownList2() throws InterruptedException {


        driver = new ChromeDriver();
        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");

        WebElement dropdown = driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));

        dropdown.click();
        Thread.sleep(1000);
        WebElement dropdownVal = driver.findElement(By.xpath("//input[@value='Java']"));

        dropdownVal.click();
        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));

        //select only check boxes which are not selected HTML,CSS sohuld not be selected
        for (WebElement ele : elements)
        {
            if(!ele.isSelected()) {
                ele.click();
                Thread.sleep(1000);
                System.out.println(ele.getAttribute("value"));
           }
        }








    }


    }


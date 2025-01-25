package PracticeMethods;

import BaseClass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OOpsConceptsInFrameWork extends baseClass {
/*
1. Inheretence  --> we have base class we extend for all the testclass  all the methods like driver, wait methods select mehtods can directly used in testclass
2. Polymorphism -->  poly means many and morphism --> forms , same operation is done in different ways , compile time polymorphism and run time polymorphism
3. Encapulation --> integrating data (variables) and code (methods) into a single unit
4. Abstraction
 */

    @Test
    public void InheretanceCallingDropdownMethodstest1()
    {

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

        // get the dropdown web element
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));

        //this for inheritance callling methods from parent class to child class
        waitForElementToBeClickable(dropdown,driver);

        //selectTheCheckbox
        WebElement sundayCheckbox = driver.findElement(By.xpath("//input[@id='sunday']"));
        selectTheCheckbox(sundayCheckbox);
       // select male radio button
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@type='radio']"));
        selectRadioButton(maleRadioButton);

        //NOTE:Variable should be public to access in other class * Dont TELL int
        System.out.println("accessing baseclass Variable :  " + browserName);


        //this for inheritance callling methods from parent class to child class
        selectDataFromDropdownList(dropdown,"Japan");

    }


    @Test
    public void Polymorphosim_MethodOverLoading() throws InterruptedException {

          driver.get(prop.getProperty("url"));
          driver.manage().window().maximize();
          WebElement nameEditBox = driver.findElement(By.xpath("//input[@id='name']"));

        // Method overloading
        //CreateUserMethod(String userName,String email);
        //CreateUserMethod(String userName,String email, String firstName,String lastName);
        //CreateUserMethod(String userName,String email, String phoneNumber,String lastName);

        //OR

          clickOnWebElement(nameEditBox, driver);
           Thread.sleep(2000);
        nameEditBox.sendKeys("Test");
          //Click on
          clickOnWebElement(By.xpath("//input[@id='email']"),driver);
          Thread.sleep(2000);
      }

    @Test
    public void Polymorphosim_MethodOverriding() throws InterruptedException {

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        WebElement nameEditBox = driver.findElement(By.xpath("//input[@id='name']"));

        // Method overriding --> use selectValuefromDropDwon()
        //CreateUserMethod(String userName,String email);

        //CreateUserMethod(String userName,String email, String firstName,String lastName);
        //CreateUserMethod(String userName,String email, String phoneNumber,String lastName);

        //OR
    }

    @Test
    public void Encapulation() throws InterruptedException {

        /*
        @FindBy(xpath="//*[text()='UserName']")
        private WebElement userName;

        @FindBy(xpath="//*[text()='Password']")
        private WebElement Password;

         @FindBy(xpath="//*[text()='Sigin']")
        private WebElement SiginButton;

        public void EnterUserName(String s)
        {
             userName.sendkeys("amar")
        }

         public void EnterPassword(String s)
        {
             Password.sendkeys("amar")
        }

         public void ClickOnSiginButton(String s)
        {
             SiginButton.click();
        }
         */

    }

    @Test
    public void DataAbstraction() throws InterruptedException {

       //Calling login method
        /*
        method implementation is done in LoignPage Class not in LoginTest Class
        jsut we are calling do login method and passing the paramenters
        and all login operations is done LoginPage class

          LoginPage lp = new LoginPage();
          lp.doLogin(String UserName,String password);



         */
    }
}

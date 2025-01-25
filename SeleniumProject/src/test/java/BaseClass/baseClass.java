package BaseClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class baseClass {

    public WebDriver driver;
    public Properties prop;
    public String browserName="CHROME";

    @BeforeClass  // --> **** IMP

    //@Parameters("browserName")
     public void setup() throws IOException {
       driver = new ChromeDriver();
       driver.get("https://testautomationpractice.blogspot.com/");

       String filePath=System.getProperty("user.dir"); // to get the dricetory
        System.out.println("filePath--> " + filePath);
       File file = new File(filePath + "\\target\\resources\\config.properties");
        FileInputStream fis = new FileInputStream(file);
        prop = new Properties();
        prop.load(fis);


       // Mulit borwser setup method
        String browserNaame ="chrome";
        if(browserNaame.equalsIgnoreCase("chrome"))
        {
           // driver = new ChromeDriver();
        }

        else if (browserNaame.equalsIgnoreCase("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        else if (browserNaame.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }



    }


    public static Boolean waitForElementToBeClickable(WebElement clickableElement, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
            Thread.sleep(500);
            System.out.println("Waited for element to be Click: " +clickableElement);
        } catch (Exception e) {
            System.out.println("Element " + clickableElement + " was not waited for Clickable: " +e.getStackTrace());
            return false;
        }
        return true;
    }


    public  static void clickOnWebElement(WebElement element, WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor)  driver;
            js.executeScript("arguments[0].click();", element);
            System.out.println("Clicked on Web element: " +element);
        } catch (Exception e) {
            System.out.println("Element " + element + " was not Clickable: " +e.getStackTrace());
        }
    }

    public  static void clickOnWebElement(By locator , WebDriver driver) {
        try {
            driver.findElement(By.xpath(String.valueOf(locator))).click();
        } catch (Exception e) {
            System.out.println("Element " + String.valueOf(locator) + " was not Clickable: " +e.getStackTrace());
        }
    }

    public static String getTextFromWebElement(WebElement element, WebDriver driver) {
        String text1 = null;
        try {
            text1 = element.getText();
            System.out.println("Captured Text from Web Element: " + element);
        } catch (Exception e) {
            System.out.println("Element " + element + " was not found in Web page: " + e.getStackTrace());
            return text1;
        }
        return text1;
    }


    public void selectDataFromDropdownList(WebElement element, String text) {
        try {
            Select dropdown = new Select(element);
            Thread.sleep(2000);
            dropdown.selectByVisibleText(text);
            Thread.sleep(1000);
            System.out.println("Selected Visible text from Element: " + element);
        } catch (Exception e) {
            System.out.println("Element " + element + " was not available for Selected Text: " + e.getStackTrace());
        }
    }

    public void selectDataFromDropdownListByIndex(WebElement element, int index) {
        try {
            Select dropdown = new Select(element);
            dropdown.selectByIndex(index);
            System.out.println("Selected text based on Index Value from Element: " + element);
        } catch (Exception e) {
            System.out.println("Element " + element + " was not available for Selected Text: " + e.getStackTrace());
        }
    }

    public void selectTheCheckbox(WebElement element) {
        try {
            if (element.isSelected()) {
                System.out.println("Checkbox is already Selected: " + element);
            } else {
                element.click();
                System.out.println("Checkbox is Selected: " + element);
            }
        } catch (Exception e) {
            System.out.println("Element " + element + " was not found in Web page: " + e.getStackTrace());
        }
    }

    public void selectRadioButton(WebElement element) {
        try {
            if (element.isSelected()) {
                System.out.println("Radio button is already Selected: " + element);
            } else {
                element.click();
                System.out.println("Radio button is Selected: " + element);
            }
        } catch (Exception e) {
            System.out.println("Element " + element + " was not found in Web page: " + e.getStackTrace());
        }
    }


    public void switchToParentFrame() {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            System.out.println("Unable to switch to the Parent Frame: " + e.getStackTrace());
        }
    }

    public String switchToChildWindow() {
        String winHandleBefore = "";
        try {
            winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            System.out.println("Window has been switched to: " + winHandleBefore);
        } catch (Exception e) {
            System.out.println("Unable to switch to the " + winHandleBefore + " Original Window: " + e.getStackTrace());
        }
        return winHandleBefore;
    }

    public void switchToWindow(String window) {
        try {
            driver.switchTo().window(window);
        } catch (Exception e) {
            System.out.println("Unable to switch to the Window: " + e.getStackTrace());
        }
    }

    public void takeScreenShoot(WebDriver driver, ITestNGMethod testMethod) throws Exception {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String nameScreenshot = testMethod.getMethodName();
        //String screenshotName = getPath(nameScreenshot);
        //FileUtils.copyFile(screenshot, new File(screenshotName));
        //Reporter.log("<a href=" + screenshotName + "</a>");
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) throws Exception {

        String methodName = testResult.getMethod().getMethodName();
        Method method = this.getClass().getMethod(methodName);
        //className = this.getClass().getSimpleName();
        String testMethodName = method.getName();
        int methodExecutionStatus = testResult.getStatus();
        //UpdateExecutionStatusToJira updateTestCaseExecutionStatusToZephyrForJira = new UpdateExecutionStatusToJira();
        //updateTestCaseExecutionStatusToZephyrForJira.update(testMethodName, methodExecutionStatus);

        if (ITestResult.FAILURE == testResult.getStatus()) {
            takeScreenShoot(driver, testResult.getMethod());
        }

        switch(testResult.getStatus())
        {
            case ITestResult.SUCCESS:
                //finalTestRunResult.put(testMethodName, "PASS");
                break;
            case ITestResult.FAILURE:
                //finalTestRunResult.put(testMethodName, "FAIL");
                break;
            case ITestResult.SKIP:
                //finalTestRunResult.put(testMethodName, "SKIP");
                break;
            default:
                break;
        }
    }




    @AfterClass   // --> **** IMP
    public void teardown() {
       driver.quit();
       driver.quit();
    }
}

package PracticeMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



    public class MultBrowserDemo {

        WebDriver driver =null;
        @BeforeTest
        @Parameters("browserName")
        public void setup(String browserNaame)
        {
            if(browserNaame.equalsIgnoreCase("chrome"))
            {
                driver = new ChromeDriver();
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


        @Test
        public void test1() throws InterruptedException
        {
            driver.get("https://google.com");
            Thread.sleep(3000);
        }


        @AfterTest
        public void teardown()
        {
            driver.quit();
            System.out.println(" Test completed successfully");

        }
}

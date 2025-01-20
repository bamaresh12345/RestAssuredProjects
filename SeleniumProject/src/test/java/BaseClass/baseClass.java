package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class baseClass {

    public WebDriver driver;
    public Properties prop;

    @BeforeClass  // --> **** IMP
    public void setup() throws IOException {
       driver = new ChromeDriver();
       driver.get("https://testautomationpractice.blogspot.com/");

       String filePath=System.getProperty("user.dir"); // to get the dricetory
       File file = new File(filePath + "\\target\\resources\\config.properties");
        FileInputStream fis = new FileInputStream(file);
        prop = new Properties();
        prop.load(fis);



    }


    @AfterClass   // --> **** IMP
    public void teardown() {
       driver.quit();
    }
}

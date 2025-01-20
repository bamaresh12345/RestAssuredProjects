import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class LoginTest {

    Playwright pt;  // public variable for all methods
    Browser browser;  // public variable for all methods
    Page page;      // public variable for all methods

    @BeforeTest
    public void setup()
    {
         pt = Playwright.create();
         browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         page = browser.newPage();

    }

    @Test
    public void launchheadlessBrowser() {

        Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://app.vwo.com/");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Test.png")));
        System.out.println(page.title());
    }

    @Test
    public void How_to_Select_Locators_Browser() throws InterruptedException {

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Test.png")));
        System.out.println(page.title());

        page.navigate("https://omayo.blogspot.com/");
        page.navigate("https://omayo.blogspot.com/", new Page.NavigateOptions());

        page.locator("//input[@name='userid']").fill("Test"); //LOCATOR and FILL Method
        page.locator("//input[@name='pswrd']").fill("Test123"); //LOCATOR and FILL Method
      //  page.wait(30000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Test.png"))); //Screenshot Method

        page.waitForSelector("//input[@type='button' and @value='Login']"); // waits till the selector load

        page.click("//input[@type='button' and @value='Login']");  //CLICK Method

        Assert.assertEquals("omayo (QAFox.com)", page.title());  // Verify Title

        page.close();



    }

    @Test
    public void Waits_and_Navigation_Locators_Browser() throws InterruptedException {

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Test.png")));
        System.out.println(page.title());

        page.navigate("https://omayo.blogspot.com/");
       // page.navigate("https://omayo.blogspot.com/", new Page.NavigateOptions());

        page.locator("//input[@name='userid']").fill("Test"); //LOCATOR and FILL Method
        page.locator("//input[@name='pswrd']").fill("Test123"); //LOCATOR and FILL Method
        //  page.wait(30000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Test.png"))); //Screenshot Method

        page.waitForSelector("//input[@type='button' and @value='Login']"); // waits till the selector load

        page.click("//input[@type='button' and @value='Login']");  //CLICK Method

        Assert.assertEquals("omayo (QAFox.com)", page.title());  // Verify Title

        String s = page.textContent("//div[@id='Text1']");
        System.out.println("page.textContent(locator):-->  " + s); // to get the textContent

        String innerText = page.innerText("//input[@name='userid']");
        System.out.println("page.innerText(locator)" + innerText);
       //String s2= page.getAttribute("//input[@name='userid']");


        page.close();



    }



    @AfterTest
    public void tearDown()
    {
        page.close();
    }
}

package Selenium.Tests;

import Selenium.POMModel.BaseClass.BaseClass;
import Selenium.Pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class LoignTests extends BaseClass {

    @Test
    public void LoginUser()
    {
        launchPlayWright();

       /* Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://omayo.blogspot.com/");*/


        LoginPage lp = new LoginPage(page);
        lp.setUserName("Hello");
        lp.setPassword("Hello");
        lp.clickLoginButton();


    }
}

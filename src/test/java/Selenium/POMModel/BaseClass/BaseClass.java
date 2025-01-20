package Selenium.POMModel.BaseClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {
    public Playwright pt;
    public Browser browser;
    public Page page;

    public void launchPlayWright()
    {
         pt = Playwright.create();
         browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://omayo.blogspot.com/");
    }

    public void closePlayWright()
    {
        pt.close();
        browser.close();
        page.close();
    }
}

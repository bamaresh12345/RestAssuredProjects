package Selenium;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class keyBoardMouseClicks {

    @Test
    public void locators() {

        Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://omayo.blogspot.com/");
        //page.click("//input[@name='userid']");
        page.keyboard().type("testing@test.com");
        page.keyboard().press("Tab");
        page.keyboard().type("testing@test.com");

        page.mouse().move(177, 22);


        page.locator("sdsdf").fill("test");
        page.locator("sdsdf").fill("hello");
        page.locator("sdsdf").click();
        page.locator("sdsdf").dblclick();
        page.locator("sdsdf").clear();

        page.locator("sdsdf").isEnabled();
        page.locator("sdsdf").isDisabled();
        page.locator("sdsdf").isChecked();
        page.locator("sdsdf").isVisible();
        page.locator("sdsdf").selectText(); // to select from dropdown
        page.locator("sdsdf").selectOption("test"); // select by text
        page.locator("sdsdf").selectOption("8"); // select by value
        //page.locator("sdsdf").selectOption();


    }


    @Test
    public void keyboard1() {

        Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://omayo.blogspot.com/");
        page.click("//input[@name='userid']");


        page.keyboard().type("testing@test.com");
        page.keyboard().press("Tab");
        page.keyboard().type("testing@test.com");
        page.keyboard().type("Enter");
        // page.keyboard().down();
        // page.keyboard().up();
       /* page.keyboard().press("Backspace");
        page.keyboard().press("Ctrl+A");
        page.keyboard().press("Ctrl+C");
        page.keyboard().press("Ctrl+V");*/




    }


     @Test
    public void CheckIsElementEnables() {

        Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://omayo.blogspot.com/");
        //page.click("//input[@name='userid']");

        page.locator("test").click();
        page.locator("test").dblclick();
        //page.locator("test").dragTo("sdfd");
        page.locator("test").screenshot();


        page.locator("test").clear();
        page.locator("test").fill("");
        page.locator("test").click();
        page.locator("test").isChecked();
        page.locator("test").isEnabled();
        page.locator("test").isVisible();
        page.locator("test").isDisabled();



        page.mouse().move(177, 22);
       // page.mouse().dblclick();
        page.mouse().move(2,3);
        page.mouse().down();
        page.mouse().up();


    }

    @Test
    public void mouseClicks() {

        Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://omayo.blogspot.com/");
        //page.click("//input[@name='userid']");

        page.locator("test").click();
        page.locator("test").dblclick();
        //page.locator("test").dragTo("sdfd");
        page.locator("test").screenshot();


        page.mouse().move(177, 22);
        // page.mouse().dblclick();
        page.mouse().move(2,3);
        page.mouse().down();
        page.mouse().up();


    }
}


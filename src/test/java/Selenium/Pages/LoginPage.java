package Selenium.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    String userName = "//input[@name='userid']";
    String password = "//input[@name='pswrd']";
    String loginButton = "//input[@type='button' and @value='Login']";



    public void setUserName(String userName1)
    {
        page.locator(userName).fill(userName1);
    }

    public void setPassword(String pwd)
    {
        page.locator(password).fill(pwd);
    }

    public void clickLoginButton()
    {
        page.locator(loginButton).click();
    }





}

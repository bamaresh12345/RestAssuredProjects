package PracticeMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelTestsTestNG {

    public WebDriver driver;
    //@Test(threadPoolSize = 3,invocationCount = 3, timeOut = 10)
    @Test
    public void test1() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        System.out.println("Hello Test1 " + Thread.currentThread());
        driver.quit();
    }



    //@Test(threadPoolSize = 3,invocationCount = 3, timeOut = 10)
    @Test
    public void test2() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://www.Test.com/");
        Thread.sleep(3000);
        System.out.println("Hello Test2 " + Thread.currentThread());
        driver.quit();
    }


    @Test
    public void test3() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.com/");
        Thread.sleep(3000);
        System.out.println("Hello Test2 " + Thread.currentThread());
        driver.quit();
    }


    @Test
    public void test4() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://www.wll.com/");
        Thread.sleep(3000);
        System.out.println("Hello Test4 " + Thread.currentThread());
        driver.quit();
    }
}
